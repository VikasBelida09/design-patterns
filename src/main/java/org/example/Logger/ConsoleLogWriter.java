package org.example.Logger;

public class ConsoleLogWriter implements LogWriter{
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
