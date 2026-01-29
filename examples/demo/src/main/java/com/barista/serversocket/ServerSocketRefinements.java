package com.barista.serversocket;

import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateSet;
import liquidjava.specification.StateRefinement;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketOption;

import liquidjava.specification.ExternalRefinementsFor;

@StateSet({"unconnected", "binded", "connected", "closed"})
@RefinementAlias("Positive(int x) {x >= 0}")
@ExternalRefinementsFor("java.net.ServerSocket")
public interface ServerSocketRefinements {
    
    // Constructors
    @StateRefinement(to="unconnected(this)")
    public void ServerSocket();

    @StateRefinement(to="binded(this)")
    public void ServerSocket(@Refinement("Positive(_)") int port);

    @StateRefinement(to="binded(this)")
    public void ServerSocket(
        @Refinement("Positive(_)") int port,
        @Refinement("Positive(_)") int backlog);
    
    @StateRefinement(to="connected(this)")
    public void ServerSocket(
        @Refinement("Positive(_)") int port,
        @Refinement("Positive(_)") int backlog,
        InetAddress bindAddr);

    // Methods
    @StateRefinement(from="unconnected(this)", to="binded(this)")
    public void bind(SocketAddress bindpoint);

    @StateRefinement(from="unconnected(this)", to="binded(this)")
    public void bind(SocketAddress bindpoint, int backlog);

    @StateRefinement(from="unconnected(this) || connected(this) || binded(this)", to="closed(this)")
    public void close();

    @StateRefinement(from="unconnected(this)", to="unconnected(this)")
    @StateRefinement(from="binded(this)", to="binded(this)")
    @StateRefinement(from="connected(this)", to="connected(this)")
    public void setSoTimeout(@Refinement("Positive(_)") int timeout);

    @StateRefinement(from="unconnected(this)", to="unconnected(this)")
    @StateRefinement(from="binded(this)", to="binded(this)")
    @StateRefinement(from="connected(this)", to="connected(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from="unconnected(this)", to="unconnected(this)")
    @StateRefinement(from="binded(this)", to="binded(this)")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwith);

    @StateRefinement(from="unconnected(this)", to="unconnected(this)")
    @StateRefinement(from="binded(this)", to="binded(this)")
    @StateRefinement(from="connected(this)", to="connected(this)")
    public <T> ServerSocket setOption(SocketOption<T> name, T value);

    @StateRefinement(from="unconnected(this)", to="unconnected(this)")
    @StateRefinement(from="binded(this)", to="binded(this)")
    @StateRefinement(from="connected(this)", to="connected(this)")
    public <T> T getOption(SocketOption<T> name);

    @StateRefinement(from="binded(this)", to="binded(this)")
    @StateRefinement(from="unconnected(this)", to="unconnected(this)")
    @StateRefinement(from="!(size >= 64000) && connected(this)", to="connected(this)")
    public void setReceiveBufferSize(int size);
}
