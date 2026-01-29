package com.undomanager;

import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoableEdit;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.swing.undo.UndoManager")
@StateSet({"start", "canEdit", "end"})
public interface UndoManagerRefinements {

    @StateRefinement(to="start(this)")
    void UndoManager();

    @StateRefinement(from="start(this)", to="canEdit(this)")
    boolean addEdit(UndoableEdit anEdit);

    @StateRefinement(from="canEdit(this)")
    void discardAllEdits();

    @StateRefinement(to="end(this)")
    void end();

    @StateRefinement(from="canEdit(this)")   
    @StateRefinement(from="end(this)")
    String getRedoPresentationName();

    @StateRefinement(from="canEdit(this)")   
    @StateRefinement(from="end(this)")
    String getUndoOrRedoPresentationName();

    @StateRefinement(from="canEdit(this)")  
    @StateRefinement(from="end(this)") 
    String getUndoPresentationName();

    @StateRefinement(from="canEdit(this)") 
    @StateRefinement(from="end(this)")  
    void redo();

    @StateRefinement(from="start(this)")
    @StateRefinement(from="canEdit(this)")
    void setLimit(int l);

    @StateRefinement(from="canEdit(this)")
    @StateRefinement(from="end(this)")
    void undo();

    @StateRefinement(from="start(this)", to="canEdit(this)")
    @StateRefinement(from="canEdit(this)")   
    @StateRefinement(from="end(this)")
    void undoableEditHappened(UndoableEditEvent e);

    @StateRefinement(from="canEdit(this)")      
    @StateRefinement(from="end(this)")
    void undoOrRedo();



    // int getLimit(); //any
    // boolean canRedo();

    // boolean canUndo();

    // boolean canUndoOrRedo();

}
