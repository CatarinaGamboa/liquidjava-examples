package com.uuid;

import java.util.UUID;

public class Test {

    void test1(){
        UUID t = new UUID(10000L, 0L);
        t.clockSequence(); // possible
    }

    void test2(){
        UUID t = UUID.randomUUID();
        t.clockSequence();
    }

    void test3(){
        UUID t = UUID.fromString("smt");
        t.clockSequence(); //possible
        t.node();
        t.variant();
    }

    void test4(){
        byte[] bytes = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        UUID t = UUID.nameUUIDFromBytes(bytes);
        t.variant();
        t.version();
        t.timestamp();//error
        
    }


}
