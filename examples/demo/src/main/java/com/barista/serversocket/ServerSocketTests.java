package com.barista.serversocket;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketTests {


    public static void test1() throws IOException {
        ServerSocket s = new ServerSocket();
        s.close();
        s.bind(null);
    }

    public static void test2() throws IOException {
        ServerSocket s = new ServerSocket(8080);
        s.bind(null);
    }

    public static void test3() throws IOException {
        ServerSocket s = new ServerSocket();
        s.bind(null);
        s.bind(null);
    }


}
