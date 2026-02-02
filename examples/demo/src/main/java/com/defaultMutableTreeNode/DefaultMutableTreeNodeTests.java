package com.defaultMutableTreeNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class DefaultMutableTreeNodeTests {
    
    public void testOk() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        node.insert(null, 0);
        node.getIndex(null);
        node.remove(0);
    }

    public void testAddUnwantedChildConstructor() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(null, false);
        node.insert(null, 0); // error
    }

    public void testAddUnwantedChildSetter() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(null, true);
        node.insert(null, 0);
        node.setAllowsChildren(false);
        node.add(null); // error
    }

    public void testAddChildInvalidIndex() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        node.insert(null, -1); // error
    }
}
