package com.example.socket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.net.SocketAddress;

@ExternalRefinementsFor("java.net.Socket")
@StateSet({"unconnected", "bound", "connected", "closed"})
public interface SocketRefinements {
	
	@StateRefinement(to="unconnected(this)")
	public void Socket();
	
	@StateRefinement(from="unconnected(this)", to="bound(this)")
	public void bind(SocketAddress add);
	
	@StateRefinement(from="bound(this)", to="connected(this)")
	public void connect(SocketAddress add);
	
	@StateRefinement(from="connected(this)")
	public void sendUrgentData(int n);
	
	@StateRefinement(from="!closed(this)", to="closed(this)")
	public void close();
}
