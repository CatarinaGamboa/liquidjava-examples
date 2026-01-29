package com.barista.dragsourcecontext;

import java.awt.dnd.DragSourceContext;
import java.util.TooManyListenersException;

public class DragSourceContextTests {
    public void test1() throws TooManyListenersException {
        DragSourceContext dnd = new DragSourceContext(null, null, null, null, null, null);
        dnd.removeDragSourceListener(null);
        dnd.dragOver(null);
        dnd.addDragSourceListener(dnd);
    }
}
