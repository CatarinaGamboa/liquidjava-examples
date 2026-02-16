package com.uuid;

import java.util.UUID;

public class Test {

    void test1(){
        long mostSigBits = 0x0000000000001000;
        UUID t = new UUID(mostSigBits, 0L);
        t.clockSequence(); // possible
    }

    void test2(){
        long mostSigBits = 0x0670034000001222L;
        UUID t = new UUID(mostSigBits, 0L);
        t.clockSequence(); // possible
    }

    void test3(){
        UUID t = UUID.randomUUID();
        t.clockSequence(); //error
    }

    void test4(){
        UUID t = UUID.fromString("smt");
        t.clockSequence(); //possible
        t.node();
        t.variant();
    }

    void test5(){
        byte[] bytes = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        UUID t = UUID.nameUUIDFromBytes(bytes);
        t.variant();
        t.version();
        t.timestamp();//error
        
    }


    void test6(){
        long mostSigBits = 0x0000000000002000;
        UUID t = new UUID(mostSigBits, 0L);
        t.clockSequence(); // error
    }


}
