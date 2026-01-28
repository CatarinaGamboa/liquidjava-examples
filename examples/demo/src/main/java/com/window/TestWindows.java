package com.window;

import java.awt.Window;

public class TestWindows {
    void test1(){
        Window w = new Window(null);
        w.pack();
        w.setType(Window.Type.NORMAL);
    }

    void test2(){
        Window w = new Window(null);
        w.setType(Window.Type.NORMAL);
        w.setVisible(false);
        w.createBufferStrategy(1);
    }

    void test3(){
        Window w = new Window(null);
        w.setType(Window.Type.NORMAL);
        w.setVisible(true);
        w.dispose();
        w.createBufferStrategy(1);
    }

    void test4(){
        Window w = new Window(null);
        w.pack();
        w.setType(Window.Type.NORMAL);
    }    
}
