package org.example.test.singleton;

public class DatabaseConnection {
    private static volatile DatabaseConnection connection;
    private DatabaseConnection(){

    }
    public static DatabaseConnection getInstance(){
            if(connection==null) {
                synchronized (DatabaseConnection.class){
                    if(connection==null){
                        connection = new DatabaseConnection();
                    }
                }
            }
        return connection;
    }
}
