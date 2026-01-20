package com.barista.socket;

import java.io.IOException;
import java.net.Socket;

public interface SocketTest {

    public static void test1() throws IOException {
        Socket s = new Socket();
        s.close();
        s.sendUrgentData(0);
    }

    public static void test2() throws IOException {
        Socket s = new Socket("localhost", 8080);
        s.bind(null);
    }


    public static void test3() throws IOException {
        Socket s = new Socket();
        s.connect(null);
        s.connect(null);
    }
    
    public static void test4() throws IOException {
        Socket s = new Socket();
        s.bind(null);
        s.bind(null);
    }

    public static void test5() throws IOException {
        Socket s = new Socket();
        s.setReceiveBufferSize(65000);
        s.setReceiveBufferSize(650);


        Socket s2 = new Socket();
        s2.bind(null);
        s2.setReceiveBufferSize(65000);
        s2.setReceiveBufferSize(650);


        Socket s3 = new Socket("x", 8080);
        s2.setReceiveBufferSize(65000);
        s2.setReceiveBufferSize(650);
    }
}
