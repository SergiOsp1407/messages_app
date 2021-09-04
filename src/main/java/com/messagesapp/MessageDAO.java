package com.messagesapp;

//Here we create the "CRUD" (Create-Read-Update-Delete)

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        Connect db_connect = new Connect();
        try(Connection cn = db_connect.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
                String query = "SELECT * FROM messages";
                ps = cn.prepareStatement(query);

                rs = ps.executeQuery();

                while( rs.next()){

                    System.out.println("ID: " + rs.getInt("id_messages"));
                    System.out.println("Mensaje: " + rs.getString("message"));
                    System.out.println("Autor: " + rs.getString("author_message"));
                    System.out.println("Fecha: " + rs.getString("date_message"));
                    System.out.println("");

                }
            }catch(SQLException e){
                System.out.println("No se pudieron recuperar los mensajes " + e.getMessage());
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());

        }



    }

    public static void deleteMessageDB(int id_message){

        Connect db_connect = new Connect();
        try(Connection cn = db_connect.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM messages WHERE id_messages = ?";
                ps = cn.prepareStatement(query);

                ps.setInt(1, id_message);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");

            }catch(SQLException e){
                System.out.println("No se pudo borrar el mensaje" + e.getMessage());
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());

        }

    }

    public static void updateMessageDB(Message message){

        Connect db_connect = new Connect();

        try(Connection cn = db_connect.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "UPDATE messages SET message = ? WHERE id_messages = ?";
                ps = cn.prepareStatement(query);

                ps.setString(1, message.getMessage());
                ps.setInt(2, message.getId_message());

                ps.executeUpdate();
                System.out.println("El mensaje ha sido editado.");

            }catch(SQLException e){
                System.out.println("No se pudo editar el mensaje" + e.getMessage());
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }



    }
}
