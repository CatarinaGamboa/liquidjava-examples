package com.example.xml;

import javax.xml.transform.SourceLocator;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;


/*
State machine:

withCause (Constructors with throwable)

^ initCause

withoutCause (other constructors)

*/

@ExternalRefinementsFor("javax.xml.transform.TransformerException")
@StateSet({"withoutCause", "withCause"})
public interface TransformerException {
	
	@StateRefinement(to="withoutCause(this)")
	public void TransformerException(String msg);

    @StateRefinement(to="withoutCause(this)")
	public void TransformerException(String msg, SourceLocator locator);

    @StateRefinement(to="withCause(this)")
	public void TransformerException(Throwable cause);
	
    @StateRefinement(to="withCause(this)")
	public void TransformerException(String message, Throwable cause);

    @StateRefinement(to="withCause(this)")
	public void TransformerException(String message, SourceLocator locator, Throwable cause);

    @StateRefinement(from="withoutCause(this)", to="withCause(this)")
    public Throwable initCause(Throwable cause);

    // This would be useful if we wanted to get rid of nulls.
    // Same for location
	//@StateRefinement(from="withCause(this)")
	public Throwable getCause();
}
