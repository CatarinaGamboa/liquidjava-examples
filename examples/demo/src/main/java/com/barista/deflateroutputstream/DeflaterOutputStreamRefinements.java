package com.barista.deflateroutputstream;

import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateSet;
import liquidjava.specification.StateRefinement;

import java.io.OutputStream;
import java.util.zip.Deflater;

import liquidjava.specification.ExternalRefinementsFor;

@StateSet({"open", "closed"})
@RefinementAlias("Nat(int x) {x > 0}")
@ExternalRefinementsFor("java.util.zip.DeflaterOutputStream")
public interface DeflaterOutputStreamRefinements {
    
    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out,
                                Deflater def,
                                @Refinement("Nat(size)") int size,
                                boolean syncFlush);

    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out,
                                Deflater def,
                                @Refinement("Nat(size)") int size);
                                    
    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out,
                                Deflater def,
                                boolean syncFlush);
                                    
    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out,
                                Deflater def);
                             
    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out,
                                boolean syncFlush);

    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out);

    @StateRefinement(from="open(this)", to="open(this)")
    public void write(int b);

    @StateRefinement(from="open(this)", to="open(this)")
    public void write(byte[] b, 
                    int off, 
                    @Refinement("Nat(len)") int len);

    @StateRefinement(from="open(this)", to="open(this)")
    public void finish();

    @StateRefinement(from="open(this)", to="open(this)")
    public void flush();

    @StateRefinement(from="open(this)", to="closed(this)")
    public void close();
}
