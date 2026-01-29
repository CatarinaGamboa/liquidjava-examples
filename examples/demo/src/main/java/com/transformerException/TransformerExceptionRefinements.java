package com.transformerException;

import javax.xml.transform.SourceLocator;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.xml.transform.TransformerException")
@StateSet({"created", "called"})
public interface TransformerExceptionRefinements {

    @StateRefinement(to="created(this)")
    public void TransformerException(String message); 

    @StateRefinement(to="created(this)")
    public void TransformerException(Throwable e);
    
    @StateRefinement(to="created(this)")
    public void TransformerException(String message, Throwable e);

    @StateRefinement(to="created(this)")
    public void TransformerException(String message, SourceLocator locator);

    @StateRefinement(to="created(this)")
    public void TransformerException(String message, SourceLocator locator, Throwable e);

    @StateRefinement(from="created(this)", to="called(this)")
    public Throwable initCause(Throwable cause); // can only be called at most once
}
