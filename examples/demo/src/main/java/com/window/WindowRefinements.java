package com.window;

import java.awt.AWTKeyStroke;
import java.awt.BufferCapabilities;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.util.Set;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@StateSet({"displayable", "notDisplayable"})
@ExternalRefinementsFor("java.awt.Window")
public interface WindowRefinements{
    
    @StateRefinement(to="notDisplayable(this)")
    void Window(Frame owner);
    
    @StateRefinement(to="notDisplayable(this)")
    void Window(Window owner);
    
    @StateRefinement(to="notDisplayable(this)")
    void Window(Window owner, GraphicsConfiguration gc);


    // to displayable
    @StateRefinement(to="displayable(this)")
    void addNotify(); // Makes this Window displayable by creating the connection to its native screen resource. This method is called internally by the toolkit and should not be called directly by programs.

    @StateRefinement(to="displayable(this)")
    void pack(); //If the window and/or its owner are not displayable yet, both of them are made displayable

    @StateRefinement(from="notDisplayable(this)")
    @StateRefinement(from="notDisplayable(this) && b",to="displayable(this)") // if its not displayable yet, is made displayable
    @StateRefinement(from="displayable(this)") // stays displayable
    void setVisible(boolean b); 


    @StateRefinement(to="notDisplayable(this)")
    void dispose(); // makes not displayable. It can be displayed again later by calling pack().

    @StateRefinement(from="displayable(this)")
    void createBufferStrategy(@Refinement("_ > 0")int numBuffers);// IllegalStateException - if the component is not displayable


    void createBufferStrategy(@Refinement("_ > 0") int numBuffers, BufferCapabilities caps);

    @StateRefinement(from="notDisplayable(this)")
    void setType(Window.Type type); // Sets the type of the window. This method can only be called while the window is not displayable.


    Set<AWTKeyStroke> getFocusTraversalKeys(@Refinement("_ >= 0 && _ <= 3") int id);

    void setOpacity(@Refinement("_ >= 0 && _ <= 1") float opacity);

}
