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

    }

    public static void deleteMessage(){

    }

    public static void editMessage(){

    }

}
