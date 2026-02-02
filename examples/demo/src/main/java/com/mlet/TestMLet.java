package com.mlet;

import javax.management.loading.MLet;

public class TestMLet {

    void test1() throws Exception{
        MLet m = new MLet();
        m.preDeregister();
    }

    void test2() throws Exception{
        MLet m = new MLet();
        m.addURL("null");
        m.preRegister(null, null);
        m.preDeregister();        
        m.postDeregister();
    }

    void test3() throws Exception{
        MLet m = new MLet();
        m.addURL("null");
        m.preRegister(null, null);
        m.postRegister(null);
        m.preDeregister();        
        m.setLibraryDirectory(null);
        m.getMBeansFromURL("null");
    }

    void test4() throws Exception{
        MLet m = new MLet();
        m.addURL("null");
        m.preRegister(null, null);
        m.postRegister(null);
        m.preDeregister();        
        m.setLibraryDirectory(null);
        m.preDeregister();        
    }


    void testGood() throws Exception{
        MLet m = new MLet();
        m.addURL("null");
        m.preRegister(null, null);
        m.postRegister(null);

        m.getMBeansFromURL("null");

        m.preDeregister();        
        m.postDeregister();
    }
    
}
