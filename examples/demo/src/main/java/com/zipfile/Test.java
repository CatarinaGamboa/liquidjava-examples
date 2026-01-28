package com.zipfile;

import java.util.zip.ZipFile;
import java.io.File;

class Test{

    void testCorrect() throws Exception{
        ZipFile z = new ZipFile(new File("try.txt"));
        z.getComment();
        z.getInputStream(null);
        z.close();
        z.getName();
    }


    void test2() throws Exception{
        ZipFile z = new ZipFile(new File("try.txt"));
        z.close();
        z.getComment();
        z.getInputStream(null);
        z.getName();
    }

    void test3() throws Exception{
        ZipFile z = new ZipFile(new File("try.txt"));
        z.close();
        z.getName();
        z.getEntry("hi");
    }



    
}