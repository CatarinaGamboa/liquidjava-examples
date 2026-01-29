package com.example.awt;

import java.awt.Component;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Ghost;
import liquidjava.specification.Refinement;



@ExternalRefinementsFor("java.awt.PopupMenu")
@Ghost("boolean isShowing")
public interface PopupMenu {
	
    /* Should also include hierarchy, but we do not support sets. */
    public void show(@Refinement("isShowing(origin) && isShowing(this)") Component origin, int x, int y);

}
