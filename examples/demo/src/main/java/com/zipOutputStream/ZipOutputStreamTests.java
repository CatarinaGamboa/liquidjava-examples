package com.zipOutputStream;

import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTests {

    void testWritingToClosedStream() throws Exception {
        FileOutputStream fos = new FileOutputStream("file");
        ZipOutputStream zos = new ZipOutputStream(fos);
        zos.setMethod(8);
        zos.setLevel(5);
        zos.close();
        zos.write(null, 0, 0); // error
    }

    void testParametricRefinements() throws Exception {
        FileOutputStream fos = new FileOutputStream("file");
        ZipOutputStream zos = new ZipOutputStream(fos);
        zos.setLevel(10); // error
    }
}