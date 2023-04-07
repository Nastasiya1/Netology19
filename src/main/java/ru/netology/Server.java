package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        String city = "???";
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    out.println(city);
                    String cityToCheck = in.readLine().toLowerCase();
                    if (city.equals("???") || cityToCheck.startsWith(String.valueOf(city.charAt(city.length() - 1)))) {
                        out.println("OK");
                        city = cityToCheck;
                    } else {
                        out.println("NOT OK");
                    }
                    System.out.println(city);
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}