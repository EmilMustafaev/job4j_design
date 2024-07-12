package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    for (String string = input.readLine(); string != null && !string.isEmpty(); string = input.readLine()) {
                        if (string.contains("msg=Exit")) {
                            output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            output.write("Server is closed".getBytes());
                            server.close();
                        }
                        if (string.contains("msg=Any")) {
                            output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            output.write("What".getBytes());
                        }
                        if (string.contains("msg=Hello")) {
                            output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            output.write("Hello".getBytes());
                        }
                        System.out.println(string);
                    }
                    output.flush();
                }
            }
        }
    }
}
