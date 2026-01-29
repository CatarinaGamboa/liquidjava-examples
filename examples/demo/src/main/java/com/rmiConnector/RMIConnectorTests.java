package com.rmiConnector;

import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIConnector;

public class RMIConnectorTests {
    
    void getConnectionIdAfterClosing() throws Exception {
        JMXServiceURL url = new JMXServiceURL("");
        RMIConnector rmi = new RMIConnector(url, null);
        rmi.connect();
        rmi.close();
        rmi.getConnectionId(); // error
    }

    void getMBeanServerConnectionWithoutConnecting() throws Exception {
        JMXServiceURL url = new JMXServiceURL("");
        RMIConnector rmi = new RMIConnector(url, null);
        rmi.getMBeanServerConnection(); // error
        rmi.close();
    }
}
