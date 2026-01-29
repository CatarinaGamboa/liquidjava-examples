package com.barista.dragsourcecontext;

import liquidjava.specification.StateSet;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.ExternalRefinementsFor;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;

@StateSet({"withListener", "noListener"})
@ExternalRefinementsFor("java.awt.dnd.DragSourceContext")
public interface DragSourceContextRefinements {

    // @StateRefinement(to="dsl == null ? withListener(this) : noListener(this)")
    @StateRefinement(to="withListener(this)")
    public void DragSourceContext(DragGestureEvent trigger,
        Cursor dragCursor,
        Image dragImage,
        Point offset,
        Transferable t,
        DragSourceListener dsl);

    @StateRefinement(from="noListener(this)", to="withListener(this)")
    public void addDragSourceListener(DragSourceListener dsl);

    @StateRefinement(from="withListener(this)", to="noListener(this)")
    public void removeDragSourceListener(DragSourceListener dsl);

    // Assumption: we always need listeners to enter drag operations
    @StateRefinement(from="withListener(this)", to="withListener(this)")
    public void dragEnter(DragSourceDragEvent dsde);

    @StateRefinement(from="withListener(this)", to="withListener(this)")
    public void dragOver(DragSourceDragEvent dsde);
    
    @StateRefinement(from="withListener(this)", to="withListener(this)")
    public void dragExit(DragSourceEvent dse);

    @StateRefinement(from="withListener(this)", to="withListener(this)")
    public void dropActionChanged(DragSourceDragEvent dsde);

    @StateRefinement(from="withListener(this)", to="withListener(this)")
    public void dragDropEnd(DragSourceDropEvent dsde);

    @StateRefinement(from="withListener(this)", to="withListener(this)")
    public void dragMouseMoved(DragSourceDragEvent dsde);
}
