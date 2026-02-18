package com.example.pipedwriter;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedWriterTest {
    void test1() throws IOException {
        PipedWriter p = new PipedWriter();
        PipedReader r = new PipedReader();
        p.connect(r);
        p.write(/*'a'*/35);
        p.flush();
        p.close();
        r.close();
    }
    void test2() throws IOException {
        PipedReader r = new PipedReader();
        PipedWriter p = new PipedWriter(r);
        char [] arr = {}; // OK for LiquidJava
        // char c = 'a';  // breaks LiquidJava

        p.write(arr, 1, 2);
        p.flush();
        p.close();
        r.close();
    }
    void testFail() throws IOException {
        PipedWriter p = new PipedWriter();
        PipedReader r = new PipedReader();
        //char [] arr = {'a', 'b', 'c'}; // breaks LiquidJava
        p.flush();
        char [] arr2 = {'a', 'b', 'c'}; // breaks LiquidJava if analyzed (it isn't here, because there's an error in p.flush() above)
        p.write(arr2, 2, 2);
        p.close();
        r.close();
    }
}
