package com.deflateroutputstream;

import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public class TestDeflater {

    void test1() throws IOException{ //correct
        DeflaterOutputStream dos = new DeflaterOutputStream(System.out);
        dos.write(0);
        dos.write(new byte[50]);
        dos.finish();
        dos.close();
    }

    void test2() throws IOException{
        DeflaterOutputStream dos = new DeflaterOutputStream(System.out);
        dos.write(0);
        dos.write(new byte[50]);
        dos.finish();
        dos.write(0); //error
        dos.close();
    }

    void test3() throws IOException{
        DeflaterOutputStream dos = new DeflaterOutputStream(System.out);
        dos.write(0);
        dos.write(new byte[50]);
        dos.finish();
        dos.flush(); //error
        dos.close();
    }

    void test4() throws IOException{
        DeflaterOutputStream dos = new DeflaterOutputStream(System.out);
        dos.write(0);
        dos.finish();
        dos.close();
        dos.flush();  //error
    }

    void test5() throws IOException{
        DeflaterOutputStream dos = new DeflaterOutputStream(System.out);
        dos.finish();
        dos.write(0); //error
        dos.close();
    }
    
    void test6() throws IOException{
        DeflaterOutputStream dos = new DeflaterOutputStream(System.out);
        dos.write(400); //error
        dos.close();
    }
    
}
