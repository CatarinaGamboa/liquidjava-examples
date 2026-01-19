package com.barista.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;

import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateSet;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.ExternalRefinementsFor;

@StateSet({"unconnected", "binded", "connected", "closed"})
@RefinementAlias("Positive(int x) {x >= 0}")
@ExternalRefinementsFor("java.net.Socket")
public interface SocketRefinements {
    
    // Constructors
    @StateRefinement(to="unconnected(this)")
    public void Socket();

    @StateRefinement(to="unconnected(this)")
    public void Socket(Proxy proxy);

    @StateRefinement(to="connected(this)")
    public void Socket(String host, @Refinement("Positive(_)") int port);

    @StateRefinement(to="connected(this)")
    public void Socket(String host, @Refinement("Positive(_)") int port, InetAddress localAddr, @Refinement("Positive(_)") int localPort);

    @StateRefinement(to="connected(this)")
    public void Socket(InetAddress address, @Refinement("Positive(_)") int port, InetAddress localAddr, @Refinement("Positive(_)") int localPort);

    // Methods
    @StateRefinement(from="unconnected(this)", to="binded(this)")
    public void bind(SocketAddress bindpoint);

    @StateRefinement(from="unconnected(this)", to="unconnected(this)")
    @StateRefinement(from="binded(this)", to="binded(this)")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwith);

    @StateRefinement(from="unconnected(this)", to="unconnected(this)")
    @StateRefinement(from="binded(this)", to="binded(this)")
    @StateRefinement(from="connected(this)", to="connected(this)")
    public <T> Socket setOption(SocketOption<T> name, T value);

    @StateRefinement(from="unconnected(this)", to="unconnected(this)")
    @StateRefinement(from="binded(this)", to="binded(this)")
    @StateRefinement(from="connected(this)", to="connected(this)")
    public <T> T getOption(SocketOption<T> name);

    @StateRefinement(from="connected(this)", to="connected(this)")
    public InputStream getInputStream();

    @StateRefinement(from="connected(this)", to="connected(this)")
    public OutputStream getOutputStream();

    @StateRefinement(from="connected(this)", to="connected(this)")
    public void sendUrgentData(int data);
    
    @StateRefinement(from="unconnected(this) || binded(this)", to="connected(this)")
    public void connect(SocketAddress endpoint);

    @StateRefinement(from="unconnected(this) || binded(this)", to="connected(this)")
    public void connect(SocketAddress endpoint, @Refinement("Positive(_)") int timeout);

    @StateRefinement(from="unconnected(this)", to="unconnected(this)")
    @StateRefinement(from="binded(this)", to="binded(this)")
    @StateRefinement(from="connected(this)", to="connected(this)")
    public void setSoLinger(boolean on, @Refinement("Positive(_)") int linger);

    @StateRefinement(from="unconnected(this) || connected(this) || binded(this)", to="closed(this)")
    public void close();
}
