package com.dragSourceContext;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("Status(int v) { 0 <= v && v <= 4 }") // DEFAULT, ENTER, OVER, CHANGED
@ExternalRefinementsFor("java.awt.dnd.DragSourceContext")
@StateSet({"noListener", "listenerSet"})
public interface DragSourceContextRefinements {
    
    @StateRefinement(to="noListener(this)")
    public void DragSourceContext(DragGestureEvent trigger, Cursor dragCursor, Image dragImage, Point offset, Transferable t, DragSourceListener dsl);

    @StateRefinement(from="noListener(this)", to="listenerSet(this)")
    public void addDragSourceListener(DragSourceListener dsl);

    // need to use ghost variable to keep track of how many listeners are registered — this only works for a single listener at a time
    @StateRefinement(from="listenerSet(this)", to="noListener(this)")
    public void removeDragSourceListener(DragSourceListener dsl);

    @StateRefinement(from="listenerSet(this)")
    public void dragEnter(DragSourceDragEvent dsde);

    @StateRefinement(from="listenerSet(this)")
    public void dragOver(DragSourceDragEvent dsde);

    @StateRefinement(from="listenerSet(this)")
    public void dragExit(DragSourceEvent dse);

    @StateRefinement(from="listenerSet(this)")
    public void dropActionChanged(DragSourceDragEvent dsde);

    @StateRefinement(from="listenerSet(this)")
    public void dragDropEnd(DragSourceDropEvent dsde);

    @StateRefinement(from="listenerSet(this)")
    public void dragMouseMoved(DragSourceDragEvent dsde);

    public void updateCurrentCursor(int sourceAct, int targetAct, @Refinement("Status(_)") int status);
}
