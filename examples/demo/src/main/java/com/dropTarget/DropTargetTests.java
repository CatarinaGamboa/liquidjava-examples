package com.dropTarget;

import java.awt.dnd.DropTarget;

public class DropTargetTests {
    
    public void testDragWhenInactive() {
        DropTarget dt = new DropTarget();
        dt.setActive(true);
        dt.dragEnter(null);
        dt.setActive(false);
        dt.dragEnter(null); // error
    }

    public void testRemoveUnaddedListener() {
        DropTarget dt = new DropTarget();
        dt.removeDropTargetListener(null); // error
    }

    public void testOk() throws Exception {
        DropTarget dt = new DropTarget();
        dt.setActive(true);
        dt.dragEnter(null);
        dt.dragOver(null);
        dt.dragExit(null);
        dt.addDropTargetListener(null);
        dt.removeDropTargetListener(null);
    }
}
