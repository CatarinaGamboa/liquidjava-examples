package com.barista.bufferedinputstream;

import java.io.InputStream;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("Positive(int x) {x >= 0}")
@StateSet({"open", "closed", "marked"})
@ExternalRefinementsFor("java.io.BufferedInputStream")
public interface BufferedInputStreamRefinements {
    
    @StateRefinement(to="open(this)")
    public void BufferedInputStream(InputStream in);

    @StateRefinement(to="open(this)")
    public void BufferedInputStream(InputStream in, @Refinement("Positive(_)") int size);

    @StateRefinement(from="open(this)", to="open(this)")
    @StateRefinement(from="marked(this)", to="marked(this)")
    public int read();

    @StateRefinement(from="open(this)", to="open(this)")
    @StateRefinement(from="marked(this)", to="marked(this)")
    public int read(byte[] b, 
        @Refinement("Positive(_)") int off, 
        @Refinement("Positive(_)") int len);
    
    @StateRefinement(from="open(this)", to="open(this)")
    @StateRefinement(from="marked(this)", to="marked(this)")
    public long skip(@Refinement("Positive(_)") long n);

    @StateRefinement(from="marked(this)", to="marked(this)")
    public int available();

    @StateRefinement(from="open(this)", to="marked(this)")
    @StateRefinement(from="marked(this)", to="marked(this)")
    public void mark(@Refinement("Positive(_)") int readlimit);

    @StateRefinement(from="marked(this)", to="marked(this)")
    public int reset();

    @StateRefinement(from="open(this)", to="open(this)")
    @StateRefinement(from="marked(this)", to="marked(this)")
    public boolean markSupported();
    
    @StateRefinement(from="open(this)", to="closed(this)")
    @StateRefinement(from="marked(this)", to="closed(this)")
    public boolean close();
}
