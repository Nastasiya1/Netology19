package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connections {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 8889);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String connectionResult = reader.readLine();
            writer.println("some name");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}