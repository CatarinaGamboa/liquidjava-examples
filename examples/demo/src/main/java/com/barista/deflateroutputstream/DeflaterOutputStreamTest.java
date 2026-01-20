package com.barista.deflateroutputstream;

import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public class DeflaterOutputStreamTest {
    public void test1() throws IOException {
        DeflaterOutputStream x = new DeflaterOutputStream(null);
        x.close();
        x.flush();
    }

    public void test2() throws IOException {
        DeflaterOutputStream x = new DeflaterOutputStream(null);
        x.write(null, 0, -10);
        x.flush();        
        x.close();
    }
}
