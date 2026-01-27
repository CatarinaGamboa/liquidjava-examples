package com.imagewriteparams;
import java.util.Locale;

import javax.imageio.ImageWriteParam;

public class Test {

    void test1(){
        ImageWriteParam iw = new ImageWriteParam(new Locale("text"));
        iw.setTilingMode(1);
        iw.setTiling(1,1,1,1); //error
    }
    
    void test2(){
        ImageWriteParam iw = new ImageWriteParam(new Locale("text"));
        iw.setTilingMode(0);
        iw.setTiling(1,1,1,1); //error
    }
    
    void test3(){
        ImageWriteParam iw = new ImageWriteParam(new Locale("text"));
        iw.setTilingMode(2);
        iw.setCompressionMode(1);
        iw.setTiling(1,1,1,1);
        iw.getBitRate(0); //error
    }

    void test4(){
        ImageWriteParam iw = new ImageWriteParam(new Locale("text"));
        iw.setCompressionMode(0);
        iw.setTiling(1, 1, 1, 1); //error

    }

    void test5(){
        ImageWriteParam iw = new ImageWriteParam(new Locale("text"));
        iw.setCompressionMode(0);
        iw.setTilingMode(2);
        iw.getCompressionMode();
        iw.setTiling(1, 1, 1, 1);
        iw.getLocalizedCompressionTypeName(); //error
    }

    void test6(){
        ImageWriteParam iw = new ImageWriteParam(new Locale("text"));
        iw.setCompressionMode(0);
        iw.setTilingMode(2);
        iw.getTileWidth(); //error
    }

    void testAllGood(){
        ImageWriteParam iw = new ImageWriteParam(new Locale("text"));
        iw.setCompressionMode(2);
        iw.setTilingMode(2);
        iw.setTiling(40, 220, 10,20);
        iw.getTileWidth(); 
        iw.setCompressionType("full");
        iw.getLocalizedCompressionTypeName();
        iw.getCompressionQuality();
        iw.unsetTiling();
    }

}
