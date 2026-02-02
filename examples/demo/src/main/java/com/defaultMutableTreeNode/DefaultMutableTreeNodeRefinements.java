package com.defaultMutableTreeNode;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("Positive(int i) { i >= 0 }")
@ExternalRefinementsFor("javax.swing.tree.DefaultMutableTreeNode")
@StateSet({"childrenAllowed", "childrenNotAllowed"})
public interface DefaultMutableTreeNodeRefinements {
    
    @StateRefinement(to="childrenAllowed(this)")
    public void DefaultMutableTreeNode();

    @StateRefinement(to="childrenAllowed(this)")
    public void DefaultMutableTreeNode(Object userObject);

    @StateRefinement(to="allowsChildren ? childrenAllowed(this) : childrenNotAllowed(this)")
    public void DefaultMutableTreeNode(Object userObject, boolean allowsChildren);

    @StateRefinement(from="childrenAllowed(this)")
    public void insert(MutableTreeNode newChild, @Refinement("Positive(_)") int childIndex);

    @StateRefinement(from="childrenAllowed(this)")
    public void add(MutableTreeNode newChild);

    @StateRefinement(to="allows ? childrenAllowed(this) : childrenNotAllowed(this)")
    public void setAllowsChildren(boolean allows);

    @Refinement("childrenAllowed(this) ? true : false")
    public boolean getAllowsChildren();

    public void remove(@Refinement("Positive(_)") int childIndex);

    public TreeNode getChildAt(@Refinement("Positive(_)") int index);

    @Refinement("Positive(_)")
    public int getChildCount();

    @Refinement("Positive(_) || _ == -1")
    public int getIndex(TreeNode aChild);
}
