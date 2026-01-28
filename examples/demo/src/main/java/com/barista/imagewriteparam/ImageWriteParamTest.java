package com.barista.imagewriteparam;

import javax.imageio.ImageWriteParam;

public class ImageWriteParamTest {
    public void test1() {
        ImageWriteParam iwp = new ImageWriteParam(null);
        iwp.setTilingMode(1);
        iwp.setTiling(0, 0, 0, 0);
    }
    
    public void test2() {
        ImageWriteParam iwp = new ImageWriteParam(null);
        iwp.setTilingMode(2);
        iwp.getTileWidth();
        iwp.setTiling(0, 0, 0, 0);
    }
        
    public void test3() {
        ImageWriteParam iwp = new ImageWriteParam(null);
        iwp.setTilingMode(2);
        iwp.setTiling(0, 0, 0, 0);
        iwp.unsetTiling();
        iwp.getTileWidth();
    }

    public void test4() {
        ImageWriteParam iwp = new ImageWriteParam(null);
        iwp.setCompressionMode(2);
        iwp.unsetCompression();
    }
}
