package com.datagramSocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketOption;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("Port(int n) { 0 <= n && n <= 65535 }")
@RefinementAlias("NonNegative(int v) { v >= 0 }")
@RefinementAlias("Positive(int v) { v > 0 }")
@RefinementAlias("TrafficClass(int tc) { 0 <= tc && tc <= 255 }")
@ExternalRefinementsFor("java.net.DatagramSocket")
@StateSet({"unbound", "bound", "connected", "disconnected", "closed" })
public interface DatagramSocketRefinements {

    @StateRefinement(to="bound(this)") // "Constructs a datagram socket and binds it to any available port on the local host machine"
    public void DatagramSocket();

    @StateRefinement(to="bound(this)")
    public void DatagramSocket(SocketAddress bindaddr); // cant check for null value to start with unbound state
    
    @StateRefinement(to="bound(this)")
    public void DatagramSocket(@Refinement("Port(_)") int port);

    @StateRefinement(from="unbound(this)", to="bound(this)")
    public void bind(SocketAddress addr);

    @StateRefinement(from="bound(this)", to="connected(this)")
    @StateRefinement(from="unbound(this)", to="connected(this)") // "If this socket is not bound then this method will first cause the socket to be bound to an address that is assigned automatically (...)"
    public void connect(InetAddress address, @Refinement("Port(_)") int port); // cant check if address is null

    @StateRefinement(from="bound(this)", to="connected(this)")
    @StateRefinement(from="unbound(this)", to="connected(this)") 
    public void connect(SocketAddress addr);  // "If given an InetSocketAddress, this method behaves as if invoking connect(InetAddress,int)"

    @StateRefinement(from="connected(this)", to="disconnected(this)")
    public void disconnect();

    @StateRefinement(from="connected(this)")
    public void send(DatagramPacket p);

    @StateRefinement(from="connected(this)")
    public void receive(DatagramPacket p);

    @StateRefinement(from="!closed(this)", to="closed(this)")
    public void close();

    @StateRefinement(from="unbound(this)")
    @StateRefinement(from="bound(this)")
    @StateRefinement(from="connected(this)")
    @StateRefinement(from="disconnected(this)")
    public <T> DatagramSocket setOption(SocketOption<T> name, T value); // "IOException - if an I/O error occurs, or if the socket is closed."

    @StateRefinement(from="unbound(this)")
    @StateRefinement(from="bound(this)")
    @StateRefinement(from="connected(this)")
    @StateRefinement(from="disconnected(this)")
    public <T> T getOption(SocketOption<T> name); // same as above

    public void setSoTimeout(@Refinement("NonNegative(_)") int timeout);

    @Refinement("NonNegative(_)")
    public int getSoTimeout();

    public void setSendBufferSize(@Refinement("Positive(_)") int size);

    @Refinement("Positive(_)")
    public int getSendBufferSize();

    public void setReceiveBufferSize(@Refinement("Positive(_)") int size);

    @Refinement("Positive(_)")
    public int getReceiveBufferSize();

    public void setTrafficClass(@Refinement("TrafficClass(_)") int tc);

    @Refinement("TrafficClass(_)")
    public int getTrafficClass();
}

