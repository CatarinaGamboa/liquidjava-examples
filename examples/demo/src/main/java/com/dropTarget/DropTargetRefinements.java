package com.dropTarget;

import java.awt.Component;
import java.awt.datatransfer.FlavorMap;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.awt.dnd.DropTarget")
@StateSet({"noListener", "listenerSet"})
@StateSet({"notActive", "active"})
public interface DropTargetRefinements {
    
    @StateRefinement(to="noListener(this) && notActive(this)")
    public void DropTarget(Component c, int ops, DropTargetListener dtl, boolean act, FlavorMap fm);

    @StateRefinement(to="noListener(this) && notActive(this)")
    public void DropTarget(Component c, int ops, DropTargetListener dtl, boolean act);

    @StateRefinement(to="noListener(this) && notActive(this)")
    public void DropTarget();

    @StateRefinement(to="noListener(this) && notActive(this)")
    public void DropTarget(Component c, DropTargetListener dtl);

    @StateRefinement(to="noListener(this) && notActive(this)")
    public void DropTarget(Component c, int ops, DropTargetListener dtl);

    @StateRefinement(from="isActive && notActive(this)", to="active(this)")
    @StateRefinement(from="!isActive && active(this)", to="notActive(this)")
    public void setActive(boolean isActive);

    @StateRefinement(from="noListener(this)", to="listenerSet(this)")
    public void addDropTargetListener(DropTargetListener dtl);

    @StateRefinement(from="listenerSet(this)", to="noListener(this)")
    public void removeDropTargetListener(DropTargetListener dtl);

    @StateRefinement(from="active(this)")
    public void dragEnter(DropTargetDragEvent dtde);

    @StateRefinement(from="active(this)")
    public void dragOver(DropTargetDragEvent dtde);

    @StateRefinement(from="active(this)")
    public void dropActionChanged(DropTargetDragEvent dtde);

    @StateRefinement(from="active(this)")
    public void dragExit(DropTargetEvent dtde);

    @StateRefinement(from="active(this)")
    public void drop(DropTargetDropEvent dtde);
}
