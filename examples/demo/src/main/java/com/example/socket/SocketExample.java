package com.example.socket;

import java.net.*;

public class SocketExample {
    
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress("localhost", 8080)); // comment for error
        socket.connect(new InetSocketAddress("example.com", 80));
        socket.close();
    }
}