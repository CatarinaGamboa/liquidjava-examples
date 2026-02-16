package com.example.abstractundoableedit;

import javax.swing.undo.AbstractUndoableEdit;

public class AbstractUndoableEditTest {
    void test1() {
        AbstractUndoableEdit a = new AbstractUndoableEdit();
        //a.die(); // if commented in, LiquidJava should report an error on the next line
        a.undo();
        a.redo();
        a.die();
    }

    void test4() {
        AbstractUndoableEdit a = new AbstractUndoableEdit();
        a.undo();
        a.die();
    }

    void test2(AbstractUndoableEdit a) {
        if (a.canUndo()) {
            a.undo();
            a.redo();
        }
    }
    void test3(AbstractUndoableEdit a) {
        if (a.canRedo()) {
            a.redo();
        }
    }
}
