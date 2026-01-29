package com.requiredmodelbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.modelmbean.ModelMBeanInfo;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.management.modelmbean.RequiredModelMBean")
@StateSet({"unregistered", "registered"})
interface RequiredModelMBeanRefinements{

    @StateRefinement(to="unregistered(this)")
    void RequiredModelMBean();

    @StateRefinement(to="unregistered(this)")
    void RequiredModelMBean(ModelMBeanInfo mbi);

    
    @StateRefinement(from="unregistered(this)")
    ObjectName preRegister(MBeanServer server, ObjectName name);

    @StateRefinement(to="registered(this)")
    void postRegister(Boolean registrationDone);


    @StateRefinement(from="registered(this)")
    void preDeregister();

    @StateRefinement(from="registered(this)", to="unregistered(this)")
    void postDeregister();

    @StateRefinement(from="unregistered(this)")
    void setModelMBeanInfo(ModelMBeanInfo mbi);

    @StateRefinement(from="unregistered(this)")   
    void load();

    // void addAttributeChangeNotificationListener(NotificationListener inlistener, String inAttributeName, Object inhandback);

    // void addNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback);

    // Object getAttribute(String attrName);

    // AttributeList getAttributes(String[] attrNames);

    // MBeanInfo getMBeanInfo();

    // MBeanNotificationInfo[] getNotificationInfo();

    // Object invoke(String opName, Object[] opArgs, String[] sig);

    // void removeAttributeChangeNotificationListener(NotificationListener inlistener, String inAttributeName);

    // void removeNotificationListener(NotificationListener listener);

    // void removeNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback);

    // void sendAttributeChangeNotification(AttributeChangeNotification ntfyObj);

    // void sendAttributeChangeNotification(Attribute inOldVal, Attribute inNewVal);

    // void sendNotification(String ntfyText);

    // void sendNotification(Notification ntfyObj);

    // void setAttribute(Attribute attribute);

    // AttributeList setAttributes(AttributeList attributes);

    // void setManagedResource(Object mr, String mr_type);

    // void store();



}