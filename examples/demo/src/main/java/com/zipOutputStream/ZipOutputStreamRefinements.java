package com.zipOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("Positive(int v) { v >= 0 }")
@RefinementAlias("Level(int v) { 0 <= v && v <= 9 }")
@StateSet({"open", "ready", "closed"})
@ExternalRefinementsFor("java.util.zip.ZipOutputStream")
public interface ZipOutputStreamRefinements {
    
    @StateRefinement(to="open(this)")
    public void ZipOutputStream(OutputStream out);

    @StateRefinement(to="open(this)")
    public void ZipOutputStream(OutputStream out, Charset charset);

    @StateRefinement(from="open(this)", to="open(this)") 
    public void setComment(/*@Refinement("'length(_) <= 65535'")*/String comment);

    @StateRefinement(from="open(this)", to="open(this)") 
    public void setMethod(@Refinement("Positive(_)") int method); // too many different possible values, none of them are negative though

    @StateRefinement(from="open(this)", to="open(this)") 
    public void setLevel(@Refinement("Level(_)") int level);

    @StateRefinement(from="open(this)", to="ready(this)") 
    public void putNextEntry(ZipEntry e) throws IOException;

    @StateRefinement(from="ready(this)", to="open(this)") 
    public void closeEntry() throws IOException;
    
    @StateRefinement(from="ready(this)", to="ready(this)") 
    public void write(byte[] b, @Refinement("Positive(_)") int off, @Refinement("Positive(_)") int len) throws IOException;

    @StateRefinement(from="ready(this)", to="ready(this)") 
    public void finish() throws IOException;

    @StateRefinement(from="!closed(this)", to="closed(this)") 
    public void close() throws IOException;
}
