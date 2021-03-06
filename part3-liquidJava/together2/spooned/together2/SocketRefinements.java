package together2;


@repair.regen.specification.ExternalRefinementsFor("java.net.Socket")
@repair.regen.specification.StateSet({ "unconnected", "binded", "connected", "closed" })
public interface SocketRefinements {
    @repair.regen.specification.StateRefinement(to = "unconnected(this)")
    public void Socket();

    @repair.regen.specification.StateRefinement(from = "unconnected(this)", to = "binded(this)")
    public void bind(java.net.SocketAddress add);

    @repair.regen.specification.StateRefinement(from = "binded(this)", to = "connected(this)")
    public void connect(java.net.SocketAddress add);

    @repair.regen.specification.StateRefinement(from = "binded(this)", to = "connected(this)")
    public void connect(java.net.SocketAddress add, int timeout);

    @repair.regen.specification.StateRefinement(from = "connected(this)")
    public void sendUrgentData(int n);

    @repair.regen.specification.StateRefinement(to = "closed(this)")
    public void close();
}

