package com.company;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class server {
    public static Connection connection;

    public static void main(String[] args) {
        try {
            connectToDb();
            ServerSocket server = new ServerSocket(2003);
            System.out.println("Waiting client");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client accepted");

                ServerThread sth = new ServerThread(socket,connection);
                sth.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void connectToDb(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/hotel","postgres","00000000");
            System.out.println("Connected to DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}