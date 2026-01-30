package com.datagramSocket;

import java.net.DatagramSocket;

public class DatagramSocketTests {
    
    public void testOk() throws Exception {
        DatagramSocket ds = new DatagramSocket(8080);
        ds.connect(null);
        ds.setSoTimeout(1000);
        ds.setSendBufferSize(100);
        ds.setReceiveBufferSize(1000);
        ds.setTrafficClass(50);
        ds.send(null);
        ds.send(null);
        ds.receive(null);
        ds.receive(null);
        ds.setOption(null, null);
        ds.getOption(null);
        ds.disconnect();
        ds.close();
    }

    public void testSendingAfterDisconnecting() throws Exception {
        DatagramSocket ds = new DatagramSocket(8080);
        ds.connect(null);
        ds.disconnect();
        ds.send(null); // error
    }

    public void testBindingAfterAlreadyBound() throws Exception {
        DatagramSocket ds = new DatagramSocket(8080);
        ds.bind(null); // error
    }
}
