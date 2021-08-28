package com.messages_app;

import java.sql.Connection;
import java.sql.SQLException;

public class main {

    public static void main(String[] args) {

        Connect connect = new Connect();

        try(Connection cnx = connect.get_connection()){

        }catch (SQLException e){
            System.out.println("Error!" + e.getMessage());
        }

    }
}
