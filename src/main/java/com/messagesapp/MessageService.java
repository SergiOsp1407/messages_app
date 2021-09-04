package com.messagesapp;

import java.util.Scanner;

public class MessageService {

    public static void createMessage(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Write your message");
        String message = sc.nextLine();

        System.out.println("Who write this message?");
        String author_name = sc.nextLine();

        Message record = new Message();
        record.setMessage(message);
        record.setMessage_author(author_name);

        MessageDAO.createMessageDB(record);
    }

    public static void listMessage(){

        MessageDAO.readMessageDB();

    }

    public static void deleteMessage(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar:");
        int id_message = sc.nextInt();

        MessageDAO.deleteMessageDB(id_message);

    }

    public static void editMessage(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje :");
        String message = sc.nextLine();

        System.out.println("Indica el ID del mensaje que deseas editar :");
        int id_message = sc.nextInt();

        Message update = new Message();
        update.setId_message(id_message);
        update.setMessage(message);

        MessageDAO.updateMessageDB(update);



    }

}
