package com.barista.droptarget;

import liquidjava.specification.StateSet;
import liquidjava.specification.StateRefinement;

import java.awt.Component;
import java.awt.datatransfer.FlavorMap;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import liquidjava.specification.ExternalRefinementsFor;

@StateSet({"noListenerOrComponent", "withListener", "withComponent", "withListenerAndComponent", "active"})
@ExternalRefinementsFor("java.awt.dnd.DropTarget")
public interface DropTargetRefinements {
    
    @StateRefinement(to="act ? active(this) : withListenerAndComponent(this)")
    public void DropTarget(Component c,
        int ops,
        DropTargetListener dtl,
        boolean act,
        FlavorMap fm
    );

    @StateRefinement(to="act ? active(this) : withListener(this)")
    public void DropTarget(Component c,
        int ops,
        DropTargetListener dtl,
        boolean act
    );

    @StateRefinement(to="withListenerAndComponent(this)")
    public void DropTarget(Component c, int ops, DropTargetListener dtl);

    @StateRefinement(to="withListenerAndComponent(this)")
    public void DropTarget(Component c, DropTargetListener dtl);

    @StateRefinement(to="noListenerOrComponent(this)")
    public void DropTarget();

    @StateRefinement(from="withListener(this)", to="withListenerAndComponent(this)")
    @StateRefinement(from="noListenerOrComponent(this)", to="withComponent(this)")
    public void setComponent(Component c);

    @StateRefinement(from="noListenerOrComponent(this)", to="withListener(this)")
    @StateRefinement(from="withComponent(this)", to="withListener(this)")
    public void addDropTargetListener(DropTargetListener dtl);

    @StateRefinement(from="withListenerAndComponent(this)", to="withComponent(this)")
    @StateRefinement(from="active(this)", to="withComponent(this)")
    @StateRefinement(from="withListener(this)", to="noListenerOrComponent(this)")
    public void removeDropTargetListener(DropTargetListener dtl);

    @StateRefinement(from="withListenerAndComponent(this)", to="isActive ? active(this) : withListenerAndComponent(this)")
    @StateRefinement(from="active(this)", to="isActive ? active(this) : withListenerAndComponent(this)")
    public void setActive(boolean isActive);

    @StateRefinement(from="active(this)", to="active(this)")
    public void dragEnter(DropTargetDragEvent dtde);

    @StateRefinement(from="active(this)", to="active(this)")
    public void dragOver(DropTargetDragEvent dtde);

    @StateRefinement(from="active(this)", to="active(this)")
    public void dropActionChanged(DropTargetDragEvent dtde);

    @StateRefinement(from="active(this)", to="active(this)")
    public void dragExit(DropTargetEvent dte);

    @StateRefinement(from="active(this)", to="active(this)")
    public void drop(DropTargetDropEvent dtde);
}
