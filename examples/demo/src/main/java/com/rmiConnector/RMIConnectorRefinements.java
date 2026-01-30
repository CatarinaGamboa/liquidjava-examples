package com.rmiConnector;

import java.util.Map;

import javax.management.MBeanServerConnection;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIServer;
import javax.security.auth.Subject;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.management.remote.rmi.RMIConnector")
@StateSet({"created", "connected", "closed"})
public interface RMIConnectorRefinements {
    
    @StateRefinement(to="created(this)")
    public void RMIConnector(JMXServiceURL url, Map<String,?> environment);

    @StateRefinement(to="created(this)")
    public void RMIConnector(RMIServer rmiServer, Map<String,?> environment);

    @StateRefinement(from="created(this)", to="connected(this)")
    public void connect();

    @StateRefinement(from="created(this)", to="connected(this)")
    public void connect(Map<String,?> environment);

    @StateRefinement(from="connected(this)")
    public String getConnectionId();

    @StateRefinement(from="connected(this)")
    public MBeanServerConnection getMBeanServerConnection();
    
    @StateRefinement(from="connected(this)")
    public MBeanServerConnection getMBeanServerConnection(Subject delegationSubject);

    @StateRefinement(from="connected(this)")
    public void addConnectionNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback);

    @StateRefinement(from="connected(this)")
    public void removeConnectionNotificationListener(NotificationListener listener);

    @StateRefinement(from="connected(this)")
    public void removeConnectionNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback);

    @StateRefinement(from="!closed(this)", to="closed(this)")
    public void close();
}
