package com.requiredmodelbean;

import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.modelmbean.RequiredModelMBean;

public class TestRequiredModel {

    void test1() throws Exception {
        RequiredModelMBean r = new RequiredModelMBean();
        r.setModelMBeanInfo(null);
        r.postRegister(Boolean.TRUE);
        r.setModelMBeanInfo(null); //error
    }

    void test2() throws Exception {
        RequiredModelMBean r = new RequiredModelMBean();
        r.setModelMBeanInfo(null);
        r.setModelMBeanInfo(null);
        r.setManagedResource(r, null);
        r.postRegister(null);
        r.load(); //error 
    }

    void test3() throws Exception {
        RequiredModelMBean r = new RequiredModelMBean();
        r.setModelMBeanInfo(null);
        r.load();
        r.setManagedResource(r, null);
        r.postRegister(null);
        r.store();
        r.postDeregister();
        r.load();
    }
}
