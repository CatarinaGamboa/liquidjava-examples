package com.socket;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;

class TestSocket{
    void test1() throws Exception{
        Socket s = new Socket();
        s.bind(new InetSocketAddress(900));
        s.close();
        s.getTrafficClass(); //error
    }    

    void test2() throws Exception{
        Socket s = new Socket();
        s.bind(new InetSocketAddress(9));
        s.setKeepAlive(false);
        s.connect(new InetSocketAddress(800));
        s.sendUrgentData(9);
        s.close();
        s.shutdownInput(); //error
    }

    void test3() throws Exception{
        Socket s = new Socket();
        s.bind(new InetSocketAddress(9));
        s.setKeepAlive(false);
        s.connect(new InetSocketAddress(800));
        s.sendUrgentData(9);
        s.shutdownInput();
        s.shutdownInput(); //error
    }

    void testGood() throws Exception{
        Socket s = new Socket();
        s.bind(new InetSocketAddress(9));
        s.setKeepAlive(false);
        s.connect(new InetSocketAddress(800));
        s.sendUrgentData(9);
        s.shutdownInput();
        s.shutdownOutput();
        s.close();
    }

    void test4() throws Exception{
        Socket s = new Socket(new Proxy(null, null));
        s.bind(); //error
        s.close();
        s.getTrafficClass();
    }    
}