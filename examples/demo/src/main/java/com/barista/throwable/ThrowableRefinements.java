package com.barista.throwable;

import liquidjava.specification.StateSet;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.ExternalRefinementsFor;

@StateSet({"withThrowable", "noThrowable"})
@ExternalRefinementsFor("java.lang.Throwable")
public interface ThrowableRefinements {
    
    @StateRefinement(to="noThrowable(this)")
    public void Throwable();

    @StateRefinement(to="noThrowable(this)")
    public void Throwable(String message);

    @StateRefinement(to="withThrowable(this)")
    public void Throwable(String message, Throwable cause);

    @StateRefinement(to="withThrowable(this)")
    public void Throwable(Throwable cause);

    @StateRefinement(to="withThrowable(this)")
    public void Throwable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace);

    @StateRefinement(from="noThrowable(this)", to="withThrowable(this)")
    public Throwable initCause(Throwable cause);
}
