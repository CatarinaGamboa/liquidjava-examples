package com.serverSocket;

import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("Port(int p) { 0 <= p && p <= 65535 }")
@RefinementAlias("Positive(int n) { n >= 0 } ")
@ExternalRefinementsFor("java.net.ServerSocket")
@StateSet({"unbound", "bound", "accepted", "closed"})
@StateSet({"hasNotBound", "hasBound"})
public interface ServerSocketRefinements {

    @StateRefinement(to="unbound(this) && hasNotBound(this)")
    public void ServerSocket();

    @StateRefinement(to="unbound(this) && hasNotBound(this)")
    public void ServerSocket(@Refinement("Port(_)") int port);

    @StateRefinement(to="unbound(this) && hasNotBound(this)")
    public void ServerSocket(@Refinement("Port(_)") int port, @Refinement("Positive(_)") int backlog);

    @StateRefinement(to="unbound(this) && hasNotBound(this)")
    public void ServerSocket(@Refinement("Port(_)") int port, @Refinement("Positive(_)") int backlog, InetAddress bindAddr);

    @StateRefinement(to="unbound(this) && hasNotBound(this)")
    public void ServerSocket(SocketImpl impl);

    @StateRefinement(from="unbound(this)", to="bound(this) && hasBound(this)")
    public void bind(SocketAddress endpoint);

    @StateRefinement(from="unbound(this)", to="bound(this) && hasBound(this)")
    public void bind(SocketAddress endpoint, @Refinement("Positive(_)") int backlog);

    // If the socket was bound prior to being closed, then this method will continue to return the local address after the socket is closed.
    // we need another stateset that does not lose information about whether the socket has been bound after closing or not
    @StateRefinement(from="hasBound(this)") 
    public InetAddress getInetAddress();

    @StateRefinement(from="hasBound(this)") 
    @Refinement("Port(_)")
    public int getLocalPort();

    @StateRefinement(from="hasBound(this)")
    public SocketAddress getLocalSocketAddress();

    @StateRefinement(from="bound(this)", to="accepted(this)")
    public Socket accept();

    @StateRefinement(from="bound(this)", to="accepted(this)")
    public void implAccept(Socket s);

    @StateRefinement(from="!closed(this)", to="closed(this)")
    public void close();

    public void setSoTimeout(@Refinement("Positive(_)") int timeout);

    @Refinement("Positive(_)")
    public int getSoTimeout();

    @StateRefinement(from="!closed(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from="accepted(this)")
    public void setReceiveBufferSize(@Refinement("Positive(_)") int size);
    
    @StateRefinement(from="unbound(this)")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth);
}