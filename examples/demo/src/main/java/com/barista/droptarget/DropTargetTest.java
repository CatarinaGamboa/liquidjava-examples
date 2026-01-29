package com.barista.droptarget;

import java.awt.dnd.DropTarget;
import java.util.TooManyListenersException;

public class DropTargetTest {
    public void test1() {
        DropTarget dt = new DropTarget();
        dt.setActive(true);
    }

    public void test2() {
        DropTarget dt = new DropTarget(null, null);
        dt.dragEnter(null);
    }

    public void test3() {
        DropTarget dt = new DropTarget(null, 1, null, false);
        dt.dragEnter(null);
    }

    public void test4() {
        DropTarget dt = new DropTarget(null, 1, null, true);
        dt.dragEnter(null);
    }

    public void test5() throws TooManyListenersException {
        DropTarget dt = new DropTarget();
        dt.addDropTargetListener(null);
        dt.dragEnter(null);
    }
    
    public void test6() throws TooManyListenersException {
        DropTarget dt = new DropTarget();
        dt.addDropTargetListener(null);
        dt.setActive(false);
        dt.dragEnter(null);
    }
    
    public void test7() throws TooManyListenersException {
        DropTarget dt = new DropTarget();
        dt.addDropTargetListener(null);
        dt.setActive(true);
    }

    public void test8() throws TooManyListenersException {
        DropTarget dt = new DropTarget();
        dt.addDropTargetListener(null);
        dt.setComponent(null);
        dt.setActive(true);
        dt.dragEnter(null);
        dt.setActive(false);
        dt.dragEnter(null);
    }
}
