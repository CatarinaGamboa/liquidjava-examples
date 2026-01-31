package com.pipedwriter;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Test {

    void test1() throws IOException{
        PipedWriter pw = new PipedWriter();
        pw.write(0);
    }

    void test2()throws IOException{
        PipedWriter pw = new PipedWriter();
        pw.connect(new PipedReader());
        pw.write("null");
        pw.flush();
        pw.close();
        pw.write(0);
    }


    void test3()throws IOException{
        PipedWriter pw = new PipedWriter();
        pw.connect(new PipedReader());
        pw.write("null");
        pw.flush();
        pw.close();
        pw.write(0);
    }
    
}
