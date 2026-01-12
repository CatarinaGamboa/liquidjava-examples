package com.bufferedreader;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderTests {
    
    void readClosedFile() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("foo.in"));
        in.close();
        in.read();
    }

    void resetUnmarkedFile() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("foo.in"));
        in.reset();
    }

    void negativeLength() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("foo.in"), -1);
    }

    void noErrors() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("foo.in"), 100);
        int bufSize = 10;
        char[] buf = new char[bufSize];
        in.ready();
        in.read();
        in.readLine();
        in.mark(10);
        in.reset();
        in.read(buf, 0, bufSize);
        in.close();
    }
}
