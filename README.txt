# Java Socket Chat Application with AI Integration

## 📌 Project Overview
This project is a **Chat Application** built in **Java** using **Socket Programming**. 
It demonstrates how a client and server can communicate over a TCP connection. 
Additionally, the server is enhanced with a **basic AI chatbot** capability to automatically respond to client messages.

The project is divided into two parts:
1. **Server (ChatServer.java)** – Listens for incoming client connections, manages communication, and can reply like a chatbot.
2. **Client (ChatClient.java)** – Connects to the server, sends messages, and receives responses.

---

## 🚀 Features
- Client-Server communication using **Java Sockets**
- Multi-client support (server can handle multiple clients)
- Server responds with **AI-like replies** (basic logic or can be extended using APIs)
- Real-time message exchange
- Extendable design to integrate external APIs (like ChatGPT or other NLP services)

---

## ⚙️ Workflow
1. **Start the Server**
   - The server is launched first and starts listening on a specific port.
   - It prints `Chat server started...` once running.

2. **Run the Client**
   - The client connects to the server using the server's IP and port.
   - After connection, the client can send messages to the server.

3. **Communication**
   - Clients send text messages to the server.
   - The server processes these messages:
     - If AI/chatbot integration is enabled → The server generates an automatic reply.
     - Otherwise, the server simply echoes or broadcasts messages.

4. **Response**
   - The client receives the server’s reply and displays it in the console.

---

## 🖥️ How It Works (Step by Step)
1. Server socket is created on a specific port (e.g., 1234).
2. Client socket connects to the server using `localhost:1234`.
3. Input/Output streams are created for communication.
4. Messages sent by the client are received by the server.
5. The server either:
   - Replies with a **basic AI response** (predefined logic), OR
   - Forwards the message to other clients.
6. Messages are displayed in real-time at both ends.

---

## 🛠️ Technologies Used
- **Java (JDK 8+)**
- **Socket Programming**
- **Multithreading (for multiple clients)**
- (Optional) **External API Integration** for AI chatbot

---

## 📂 Project Structure
```
ChatApp/
│── server/
│   └── ChatServer.java
│── client/
│   └── ChatClient.java
│── README.md
```

---

## ▶️ How to Run
1. Open terminal in project folder.
2. Compile the server and client code:
   ```sh
   javac server/ChatServer.java client/ChatClient.java
   ```
3. Run the server:
   ```sh
   java server.ChatServer
   ```
4. In another terminal, run the client:
   ```sh
   java client.ChatClient
   ```
5. Start chatting!

---

## 🔮 Future Enhancements
- Add a GUI (JavaFX / Swing)
- Store chat logs in a database (SQLite/MySQL)
- Add user authentication (login system)
- Enhance AI responses by integrating real chatbot APIs

---

## 👨‍💻 Author
**Krunal Waghela**  
Electronics & Telecommunication Student | Cybersecurity & AI Enthusiast

---

## 📜 License
This project is open-source and free to use.
