package com.example.awt;

import java.awt.AWTException;
import java.awt.BufferCapabilities;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;



@ExternalRefinementsFor("java.awt.Window")
@StateSet({"invisible", "visible"})
@StateSet({"displayable", "notDisplayable"})
@StateSet({"notFullscreen", "fullscreen"})
@StateSet({"decorated", "undecorated"})
public interface Window {
    @StateRefinement(to="invisible(this)")
    @StateRefinement(to="notDisplayable(this)")
    @StateRefinement(to="fullscreen(this)")
    @StateRefinement(to="undecorated(this)")
    void Window(Frame owner); 

    @StateRefinement(to="invisible(this)")
    @StateRefinement(to="notDisplayable(this)")
    @StateRefinement(to="fullscreen(this)")
    @StateRefinement(to="undecorated(this)")
    void Window(Window owner); 

    @StateRefinement(to="invisible(this)")
    @StateRefinement(to="notDisplayable(this)")
    @StateRefinement(to="fullscreen(this)")
    @StateRefinement(to="undecorated(this)")
    void Window(Window owner, GraphicsConfiguration gc); 
    
    @StateRefinement(from="notDisplayable(this)")
    void setType(java.awt.Window.Type type);

    @StateRefinement(to="displayable(this)")
    public void addNotify();

    @StateRefinement(to="displayable(this)")
    public void pack();

    // Check this
    @StateRefinement(to="(visible ? displayable(this) : true) && (visible ? visible(this) : invisible(this))")
    public void setVisible(boolean visible);

    @StateRefinement(from="displayable(this)", to="notDisplayable(this) && invisible(this)")
    public void dispose();

    @StateRefinement(from="displayable(this)")
    public void createBufferStrategy(@Refinement("numBuffers >= 1") int numBuffers);

    public void createBufferStrategy(@Refinement("numBuffers >= 1") int numBuffers, BufferCapabilities caps) throws AWTException;

    // Check this, not intuitive from javadoc
    @StateRefinement(from="undecorated(this) || notFullscreen(this) || opacity == 1.0")
    public void setOpacity(@Refinement("opacity >= 0.0 && opacity <= 1.0") float opacity);


    // TODO: Requires NULL support and constants
    // public void setShape(Shape shape);
}
