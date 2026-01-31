package com.abstractundo;

import javax.swing.undo.AbstractUndoableEdit;

public class TestAbstractUndo {
    
    void test1(){
        AbstractUndoableEdit a = new AbstractUndoableEdit();
        a.redo();
    }

    void test2(){
        AbstractUndoableEdit a = new AbstractUndoableEdit();
        a.undo();
        a.redo();
        a.undo();
        a.undo();
    }

    void test3(){
        AbstractUndoableEdit a = new AbstractUndoableEdit();
        a.undo();
        a.redo();
        a.undo();
        a.die();
        a.redo();
    }
}
