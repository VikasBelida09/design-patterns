package org.example.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final String PROPERTIES_FILE="logger.properties";
    public static Properties loadProperties(){
        Properties properties=new Properties();
        try(InputStream input=PropertiesLoader.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)){
            if(input==null){
                throw new RuntimeException("Properties file not found: "+PROPERTIES_FILE);
            }
            properties.load(input);
        }catch (IOException e){
            throw new RuntimeException("Failed to load properties: "+PROPERTIES_FILE);
        }
        return properties;
    }
}
