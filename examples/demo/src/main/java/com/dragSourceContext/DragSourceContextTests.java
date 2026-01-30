package com.dragSourceContext;

import java.awt.dnd.DragSourceContext;

public class DragSourceContextTests {
    
    public void testRemoveUnregisteredListener() {
        DragSourceContext dsc = new DragSourceContext(null, null, null, null, null, null);
        dsc.removeDragSourceListener(null); // error
    }

    public void testOk() throws Exception {
        DragSourceContext dsc = new DragSourceContext(null, null, null, null, null, null);
        dsc.addDragSourceListener(null);
        dsc.removeDragSourceListener(null);
        dsc.addDragSourceListener(null);
        dsc.dragEnter(null);
        dsc.dragExit(null);
    }
}
