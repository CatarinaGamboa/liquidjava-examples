package com.abstractundo;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;



@StateSet({"aliveDone", "aliveNotDone", "notAlive"})
@ExternalRefinementsFor("javax.swing.undo.AbstractUndoableEdit")
public interface AbstractUndoRefinements {

    @StateRefinement(to="aliveDone(this)")
    void AbstractUndoableEdit();

    @StateRefinement(from="aliveNotDone(this)", to="aliveDone(this)")
    void redo();

    @StateRefinement(from="aliveDone(this)", to="aliveNotDone(this)")
    void undo();

    @StateRefinement(from="!notAlive(this)", to="notAlive(this)")
    void die();


    // anything
    // boolean canRedo();
    // boolean canUndo();

    // boolean addEdit(UndoableEdit anEdit);
    // String getPresentationName();
    // String getRedoPresentationName();
    // String getUndoPresentationName();
    // boolean isSignificant();
    // boolean replaceEdit(UndoableEdit anEdit);
    // String toString();

    
}
