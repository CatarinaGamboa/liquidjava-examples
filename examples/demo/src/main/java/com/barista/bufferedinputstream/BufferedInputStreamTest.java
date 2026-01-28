package com.barista.bufferedinputstream;

import java.io.BufferedInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {
    public void test1() throws IOException {
            BufferedInputStream x = new BufferedInputStream(null);
            x.close();
            x.available();
    }

    public void test2() throws IOException {
            BufferedInputStream x = new BufferedInputStream(null);
            x.available();
    }
}
