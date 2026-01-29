package com.serverSocket;

import java.net.ServerSocket;
import java.net.SocketAddress;

public class ServerSocketTests {

    private SocketAddress addr;

    public void testParametric() throws Exception {
        ServerSocket s = new ServerSocket(-1, -2); // error

    }
    
    public void testBindTwice() throws Exception {
        ServerSocket s = new ServerSocket();
        s.bind(addr);
        s.bind(addr); // error
    }

    public void testBindClosed() throws Exception {
        ServerSocket s = new ServerSocket();
        s.close();
        s.bind(addr); // error
    }

    public void testOk() throws Exception {
        ServerSocket s = new ServerSocket();
        s.bind(addr);
        s.accept();
        s.setReceiveBufferSize(100);
        s.close();
    }
}

