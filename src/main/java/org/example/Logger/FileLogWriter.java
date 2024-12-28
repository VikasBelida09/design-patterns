package org.example.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogWriter implements LogWriter{
    private final String directory;
    private final String fileNamePattern;
    private final long fileMaxSize;
    private File currentFile;
    private BufferedWriter writer;

    public FileLogWriter(String directory, String fileNamePattern, long fileMaxSize) {
        this.directory = directory;
        this.fileNamePattern = fileNamePattern;
        this.fileMaxSize = fileMaxSize;
        initializeFileWriter();
    }
    private void initializeFileWriter(){
        try{
            Path logDir= Paths.get(directory);
            if(!Files.exists(logDir)){
                Files.createDirectories(logDir);
            }
            currentFile=new File(logDir.toString(), generateFileName());
            writer=new BufferedWriter(new FileWriter(currentFile,true));
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize FileLogWriter",e);
        }
    }
    private String generateFileName(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fileNamePattern.replace("%d", LocalDateTime.now().format(formatter));
    }
    @Override
    public void write(String message) {
        try {
            if (currentFile.length() >= fileMaxSize) {
                rotateLogFile();
            }
            writer.write(message);
            writer.newLine();
            writer.flush();
        }catch (IOException e){
            throw new RuntimeException("Failed to write the log file");
        }
    }
    private void rotateLogFile(){
        try{
            writer.close();
            String archivedName=currentFile.getName().replace(".log","-"+System.currentTimeMillis()+".log");
            currentFile.renameTo(new File(currentFile.getParent(),archivedName));
            currentFile=new File(currentFile.getParent(), generateFileName());
            writer=new BufferedWriter(new FileWriter(currentFile, true));
        }catch (IOException ex){
            throw new RuntimeException("Failed to rotate log file", ex);
        }
    }
}
