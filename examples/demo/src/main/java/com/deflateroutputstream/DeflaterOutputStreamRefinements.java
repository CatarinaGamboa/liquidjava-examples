package com.deflateroutputstream;

import java.io.OutputStream;
import java.util.zip.Deflater;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.util.zip.DeflaterOutputStream")
@StateSet({"open", "finished", "closed"})
@RefinementAlias("Byte(int x) {x >= -128 && x <= 127}")
public interface DeflaterOutputStreamRefinements {

    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out);

    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out, boolean syncFlush);

    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def);

    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def, boolean syncFlush);

    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def, int size);

    @StateRefinement(to="open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def, int size, boolean syncFlush);

    @StateRefinement(from="!closed(this)", to="closed(this)")
    public void close();

    @StateRefinement(from="open(this)", to="finished(this)")
    public void finish();

    @StateRefinement(from="open(this)")
    public void flush();

    @StateRefinement(from="open(this)")
    public void write(byte[] b, int off, @Refinement("len > 0") int len);
    
    @StateRefinement(from="open(this)")
    public void write(@Refinement("Byte(b)")int b);


}
