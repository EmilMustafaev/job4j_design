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
                    String firstLine = input.readLine();
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());

                    if (firstLine != null) {
                        if (firstLine.contains("msg=Exit")) {
                            output.write("Server is closed".getBytes());
                            server.close();
                        } else if (firstLine.contains("msg=Any")) {
                            output.write("What".getBytes());
                        } else if (firstLine.contains("msg=Hello")) {
                            output.write("Hello".getBytes());
                        }
                    }

                    System.out.println(firstLine);
                    String line;
                    while ((line = input.readLine()) != null && !line.isEmpty()) {
                        System.out.println(line);
                    }

                    output.flush();
                }
            }
        }
    }
}
