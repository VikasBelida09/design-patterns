package org.example.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CustomLoggerFactory {
    private static AsyncLogWriter asyncLogWriter;
    private static final Map<String, Logger> loggerCache=new HashMap<>();
    public static Logger getLogger(Class<?> className) {
        String classNameKey=className.getName();
        synchronized (loggerCache){
            if(loggerCache.containsKey(classNameKey)){
                return loggerCache.get(classNameKey);
            }
            Properties properties=PropertiesLoader.loadProperties();
            LogLevel level=getLogLevel(properties);
            LogWriter logWriter= getLogWriter(properties);
            logWriter=new AsyncLogWriter(logWriter);
            if(getIsAsyncEnabled(properties)){
                logWriter=new AsyncLogWriter(logWriter);
                asyncLogWriter=(AsyncLogWriter) logWriter;
                registerAsyncLogWriterShutdownHook(properties);
            }
            Logger logger=new Logger(logWriter, level,className);
            loggerCache.put(classNameKey,logger);
            return logger;
        }
    }
    private static LogLevel getLogLevel(Properties properties){
        String level=properties.getProperty("logger.log.level","INFO");
        try{
            return LogLevel.valueOf(level.toUpperCase());
        }catch(IllegalArgumentException e){
            throw new RuntimeException("Invalid log level in configuration: "+ level);
        }
    }
    private static LogWriter getLogWriter(Properties properties){
        String writer= properties.getProperty("logger.log.writer","CONSOLE");
        return switch (writer){
            case "FILE" -> createFileLogWriter(properties);
            case "DATABASE" -> new DatabaseLogWriter();
            default -> new ConsoleLogWriter();
        };
    }
    private static FileLogWriter createFileLogWriter(Properties properties){
        String directory=properties.getProperty("logger.file.directory","./logs");
        String pattern=properties.getProperty("logger.file.pattern","myapp-log-%d{yyyy-MM-dd}.log");
        String maxSizeStr=properties.getProperty("logger.file.max-size","10MB");

        long maxSize=parseMaxSize(maxSizeStr);
        return new FileLogWriter(directory,pattern, maxSize);
    }
    private static long parseMaxSize(String maxSizeStr){
        try{
            if(maxSizeStr.toUpperCase().endsWith("MB")){
                return Long.parseLong(maxSizeStr.replace("MB","").trim())*1024*1024;
            }else if(maxSizeStr.toUpperCase().endsWith("KB")){
                return Long.parseLong(maxSizeStr.replace("KB","").trim())*1024;
            }else{
                return Long.parseLong(maxSizeStr.trim());
            }
        }catch(NumberFormatException ex){
            throw new RuntimeException("Invalid max file size in configuration: "+maxSizeStr, ex);
        }
    }
    private static boolean getIsAsyncEnabled(Properties properties){
        return Boolean.parseBoolean(properties.getProperty("logger.async.enabled","True"));
    }
    private static void registerAsyncLogWriterShutdownHook(Properties properties){
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            if(asyncLogWriter!=null){
                System.out.println("shutting down async logger..");
                long startTime=System.currentTimeMillis();
                asyncLogWriter.shutdown();
                long gracePeriod=Long.parseLong(properties.getProperty("logger.async.shutdown.grace-period","1000"));
                while(!asyncLogWriter.isQueueEmpty() && (System.currentTimeMillis()-startTime)<gracePeriod){
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException ex){
                        Thread.currentThread().interrupt();
                        System.err.println("Shutdown hook interrupted");
                    }
                }
                if(!asyncLogWriter.isQueueEmpty()){
                    System.err.println("Not all logs were flushed within the grace period");
                }else{
                    System.out.println("All logs flushed successfully before shutdown");
                }
            }
        }));
    }
}
