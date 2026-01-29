
package com.undomanager;

import javax.swing.undo.UndoManager;

public class TestUndoManager {

    void test1(){
        UndoManager u = new UndoManager();
        u.addEdit(null);
        u.redo();
        u.setLimit(10);
        u.redo();
        u.end();
        u.setLimit(10); //error
    }

    void testGood(){
        UndoManager u = new UndoManager();
        u.addEdit(null);
        u.redo();
        u.setLimit(10);
        u.redo();
        u.end();
        u.undoOrRedo();
    }

    void test2(){
        UndoManager u = new UndoManager();
        u.undo();
        u.addEdit(null);
    }

    void test3(){
        UndoManager u = new UndoManager();
        u.undoableEditHappened(null);
        u.undo();
        u.end();
        u.setLimit(100);//error
    }
}