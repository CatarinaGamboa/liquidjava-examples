package com.mLet;

import javax.management.loading.MLet;

public class MLetTests {
    
    public void testOk() throws Exception {
        MLet mlet = new MLet();
        mlet.addURL("");
        mlet.preRegister(null, null);
        mlet.postRegister(true);
        mlet.preDeregister();
        mlet.postDeregister();
    }

    public void testNotRegistering() throws Exception {
        MLet mlet = new MLet();
        mlet.addURL("");
        mlet.preRegister(null, null);
        mlet.getMBeansFromURL(""); // error
    }

    public void testUnregisterTwice() throws Exception {
        MLet mlet = new MLet();
        mlet.addURL("");
        mlet.preRegister(null, null);
        mlet.postRegister(true);
        mlet.preDeregister();
        mlet.postDeregister();
        mlet.postDeregister(); // error
    }
}
