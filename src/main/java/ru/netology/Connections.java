package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connections {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8989);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String previousCity = reader.readLine().toLowerCase();
            System.out.println(previousCity);

            Scanner scanner = new Scanner(System.in);
            String nextCity = scanner.nextLine();
            writer.println(nextCity.toLowerCase());
            System.out.println(reader.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}