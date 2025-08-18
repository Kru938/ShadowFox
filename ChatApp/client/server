package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Chat server started...");
        ServerSocket serverSocket = new ServerSocket(5200);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket);
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // broadcast original message to all clients
                    synchronized (clientWriters) {
                        for (PrintWriter writer : clientWriters) {
                            writer.println("User: " + message);
                        }
                    }

                    // 💡 generate AI-like reply from server
                    String reply = generateReply(message);

                    // send reply to all clients
                    synchronized (clientWriters) {
                        for (PrintWriter writer : clientWriters) {
                            writer.println("Server (AI): " + reply);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try { socket.close(); } catch (IOException e) {}
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            }
        }
    }

    // -------------------------------
    // AI-like reply generator
    // -------------------------------
    private static String generateReply(String msg) {
        msg = msg.toLowerCase();
        if (msg.contains("hello")) return "Hi there! 👋";
        if (msg.contains("how are you")) return "I’m doing great, thanks!";
        if (msg.contains("bye")) return "Goodbye! Have a nice day!";
        if (msg.contains("help")) return "Sure! What do you need help with?";
        if (msg.contains("joke")) return "Why did the scarecrow win an award? Because he was outstanding in his field! 😂";
        if (msg.contains("weather")) return "I can’t check the weather, but I hope it’s nice where you are! ☀️";
        if (msg.contains("news")) return "I’m not up-to-date with the news, but I hope it’s good! 📰";
        if (msg.contains("love")) return "Love is a beautiful thing! ❤️";
        if (msg.contains("food")) return "I love food too! What’s your favorite? 🍕";
        if (msg.contains("music")) return "Music is the soundtrack of life! 🎶";
        if (msg.contains("movie")) return "I enjoy a good movie! What’s your favorite genre? 🎬";
        if (msg.contains("game")) return "Games are fun! What’s your favorite game? 🎮";
        if (msg.contains("advice")) return "Always be kind and stay curious! 🌟";
        if (msg.contains("quote")) return "“The only way to do great work is to love what you do.” - Steve Jobs";
        if (msg.contains("inspire")) return "Believe in yourself and all that you are. 🌟";
        if (msg.contains("story")) return "Once upon a time, in a land far away, there lived a wise old owl... 🦉";
        if (msg.contains("fun fact")) return "Did you know that honey never spoils? 🍯";

        return "I didn’t understand that 🤔";
    }
}
