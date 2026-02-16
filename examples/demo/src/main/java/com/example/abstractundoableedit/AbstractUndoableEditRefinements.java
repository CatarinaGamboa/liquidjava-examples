package com.example.abstractundoableedit;

import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.swing.undo.AbstractUndoableEdit")
@StateSet({"alive_done", "not_alive_done", "alive_not_done", "not_alive_not_done"})
public interface AbstractUndoableEditRefinements {
    @StateRefinement(to="alive_done(this)")
    public void AbstractUndoableEdit();

    @StateRefinement(from="alive_done(this)", to="not_alive_done(this)")
    @StateRefinement(from="alive_not_done(this)", to="not_alive_not_done(this)")
    public void die();


    @StateRefinement(from="alive_done(this)", to="alive_not_done(this)")
    public void undo() throws CannotUndoException;

    @Refinement("_ && alive_done(this) || !_ && !alive_done(this)")
    public boolean canUndo();

    @StateRefinement(from="alive_not_done(this)", to="alive_done(this)")
    public void redo() throws CannotUndoException;

    @Refinement("_ && alive_not_done(this) || !_ && !alive_not_done(this)")
    public boolean canRedo();

    public boolean addEdit(UndoableEdit anEdit);

    public boolean replaceEdit(UndoableEdit anEdit);

    public boolean isSignificant();

    public String getPresentationName();

    public String getUndoPresentationName();

    public String getRedoPresentationName();

    public String toString();
}
