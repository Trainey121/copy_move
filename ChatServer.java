package tcp;

import java.io.*;
import java.net.*;

public class ChatServer {

    private static final int PORT = 3000;

    public static void main(String argv[]) throws Exception {
        ServerSocket server = new ServerSocket(ChatServer.PORT);
		System.out.println("Server running...");
        while (true) {
            Socket conn = server.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            DataOutputStream output = new DataOutputStream(conn.getOutputStream());

            String message = input.readLine();
            System.out.println("Received: " + message);
            output.writeBytes(message.toUpperCase() + '\n');

            conn.close();
        }
    }
}