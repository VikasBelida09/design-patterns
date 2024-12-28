package org.example.Logger;

import java.time.LocalDateTime;
import java.util.Properties;

public class Logger {
    private final LogLevel level;
    private final LogWriter logWriter;
    private final Class<?> className;
    private final String messageFormat;
    public Logger(LogWriter writer,LogLevel level, Class<?> className){
        this.logWriter=writer;
        this.level=level;
        this.className=className;
        this.messageFormat=getMessageFormat();
    }
    public String getMessageFormat(){
        Properties properties=PropertiesLoader.loadProperties();
        return properties.getProperty("logger.log.format","[%d{yyyy-MM-dd HH:mm:ss}] [%level] [%class] - %message");
    }
    public void log(Object message){
        String formattedMessage=this.getFormattedMessage(message.toString());
        System.out.println("this is formatted message: "+formattedMessage);
        logWriter.write(formattedMessage);
    }
    private String getFormattedMessage(String message){
        return messageFormat.replaceAll("%d\\{.*?}",LocalDateTime.now().toString())
                .replace("%level",this.level.toString())
                .replace("%class",this.className.toString())
                .replace("%message",message);
    }
    public void shutdown(){
        if(this.logWriter instanceof AsyncLogWriter){
            ((AsyncLogWriter) this.logWriter).shutdown();
        }
    }
}
