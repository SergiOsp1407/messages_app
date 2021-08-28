package com.messagesapp;

//Here we create the "CRUD" (Create-Read-Update-Delete)

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {

    public static void createMessageDB(Message message){

        Connect db_connect = new Connect();
        try(Connection cn = db_connect.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO messages (message,author_message) VALUES (?,?)";
                ps = cn.prepareStatement(query);

                ps.setString(1, message.getMessage());
                ps.setString(2, message.getMessage_author());

                ps.executeUpdate();
                System.out.println("Message created");

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());

        }

    }

    public static void readMessageDB(){

    }

    public static void deleteMessageDB(int id_message){

    }

    public static void updateMessageDB(Message message){

    }
}
