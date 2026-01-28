package com.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.Socket;


import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.net.Socket")
@RefinementAlias("Port(int x) {x >= 0 && x <= 65535 }")
@StateSet({"unconnected", "bound", "connected", "closed", "inputShutdown", "outputShutdown", "bothShutdown"})
interface SocketRefinements {

    @StateRefinement(to="unconnected(this)")
    void Socket();

    @StateRefinement(to="unconnected(this)")
    void Socket(Proxy proxy);

    @StateRefinement(to="connected(this)")
    void Socket(String host, @Refinement("Port(_)") int port);

    @StateRefinement(to="connected(this)")
    void Socket(String host, @Refinement("Port(_)") int port, InetAddress localAddr, @Refinement("Port(_)") int localPort);

    @StateRefinement(to="connected(this)")    
    void Socket(InetAddress address, @Refinement("Port(_)") int port);
 
    @StateRefinement(to="connected(this)")   
    void Socket(InetAddress address, @Refinement("Port(_)") int port, InetAddress localAddr, @Refinement("Port(_)") int localPort);
      
    @StateRefinement(from="bound(this)", to="connected(this)")   
    void connect(SocketAddress endpoint);

    @StateRefinement(from="bound(this)", to="connected(this)")   
    void connect(SocketAddress endpoint, @Refinement("_ >= 0")int timeout);

    @StateRefinement(from="unconnected(this)", to ="bound(this)")
    void bind(SocketAddress bindpoint);

    @StateRefinement(from="!unconnected(this) && !bound(this)")
    InetAddress getInetAddress();

    @StateRefinement(from="!unconnected(this) && !bound(this)")
    InetAddress getLocalAddress();

    @StateRefinement(from="!unconnected(this) && !bound(this)")
    int getPort();

    @StateRefinement(from="!unconnected(this)")
    int getLocalPort();

    @StateRefinement(from="!unconnected(this)")
    SocketAddress getLocalSocketAddress();
    
    @StateRefinement(from="connected(this)")
    @StateRefinement(from="outputShutdown(this)")
    InputStream getInputStream();
    
    @StateRefinement(from="connected(this)")
    @StateRefinement(from="inputShutdown(this)")
    OutputStream getOutputStream();

 
    @StateRefinement(from="connected(this)")
    public void sendUrgentData(int data);

    @StateRefinement(from="connected(this)")
    public void setTrafficClass(int tc);

    @StateRefinement(from="connected(this)")
    public int getTrafficClass();

    @StateRefinement(from="connected(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from="connected(this)")
    public boolean getReuseAddress();

    @StateRefinement(from="!closed(this)", to="closed(this)")
    public void close();

    @StateRefinement(from="connected(this)",to="inputShutdown(this)")
    @StateRefinement(from="outputShutdown(this)",to="bothShutdown(this)")
    public void shutdownInput();

    @StateRefinement(from="connected(this)",to="outputShutdown(this)")
    @StateRefinement(from="inputShutdown(this)",to="bothShutdown(this)")
    public void shutdownOutput();



    // @StateRefinement(from="!closed(this)")
    // public void setPerformancePreferences(int connectionTime, int latency, int bandwidth);

    // @StateRefinement(from="!closed(this)")  
    // public <T> Socket setOption(SocketOption<T> name, T value);
    
    // @StateRefinement(from="!closed(this)")  
    // public <T> T getOption(SocketOption<T> name);

    // void setTcpNoDelay(boolean on);
    
    // @StateRefinement(from="!closed(this)")
    // public boolean getTcpNoDelay();

    // @StateRefinement(from="!closed(this)")
    // public void setSoLinger(boolean on, int linger);

    // @StateRefinement(from="!closed(this)")
    // public int getSoLinger();

    // @StateRefinement(from="!closed(this)")
    // public void setOOBInline(boolean on);

    // @StateRefinement(from="!closed(this)")
    // public boolean getOOBInline();

    // @StateRefinement(from="!closed(this)")    
    // public void setSoTimeout(int timeout);

    // @StateRefinement(from="!closed(this)")
    // public int getSoTimeout();

    // @StateRefinement(from="!closed(this)")
    // public void setSendBufferSize(int size);

    // @StateRefinement(from="!closed(this)")
    // public int getSendBufferSize();

    // @StateRefinement(from="!closed(this)")
    // public void setReceiveBufferSize(int size);

    // @StateRefinement(from="!closed(this)")
    // public int getReceiveBufferSize();

    // @StateRefinement(from="!closed(this)")
    // public void setKeepAlive(boolean on);



 
} 