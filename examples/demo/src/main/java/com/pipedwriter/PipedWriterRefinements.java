package com.pipedwriter;

import java.io.PipedReader;
import java.io.PipedWriter;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.io.PipedWriter")
@StateSet({"started", "connected", "closed"})
public interface PipedWriterRefinements {

    @StateRefinement(to="started(this)")
    void PipedWriter();
    
    @StateRefinement(to="started(this)")
    void PipedWriter(PipedReader snk);

    @StateRefinement(from="!closed(this)", to="closed(this)")
    void close();

    @StateRefinement(from="started(this)", to="connected(this)")
    void connect(PipedReader snk);

    @StateRefinement(from="connected(this)")
    void flush();

    @StateRefinement(from="connected(this)")
    void write(char[] cbuf, @Refinement("_ > 0") int off, @Refinement("_ > 0") int len);

    @StateRefinement(from="connected(this)")
    void write(int c);
    
}
