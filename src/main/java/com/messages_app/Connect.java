package com.messages_app;

import java.sql.DriverManager;
import java.sql.*;

public class Connect {

    //Method that have all to connect to the DB
    public Connection get_connection(){

        Connection cn = null;

        //This try-catch establish the connection to DB with the info used in MySQL
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/message_app","root","");

            if( cn != null){
                System.out.println("DataBase connection successful");
            }

        }catch(SQLException e){
            System.out.println("Error trying to connect to DB " + e.getMessage());
        }
        return cn;
    }
}
