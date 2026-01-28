package com.zipfile;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementPredicate;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.util.zip.ZipFile")
@StateSet({"open", "closed"})
public interface ZipFileRefinements {
    
    // Constructors
    @StateRefinement(to="open(this)")
    void ZipFile(File file);
    @StateRefinement(to="open(this)")
    void ZipFile(File file, @Refinement("mode == 1 || mode == 4") int mode);
    @StateRefinement(to="open(this)")
    void ZipFile(File file, @Refinement("mode == 1 || mode == 4") int mode, Charset charset);
    @StateRefinement(to="open(this)")
    void ZipFile(File file, Charset charset);
    @StateRefinement(to="open(this)")
    void ZipFile(String name);
    @StateRefinement(to="open(this)")
    void ZipFile(String name, Charset charset);

    @StateRefinement(from="open(this)", to="closed(this)")
    void close();

    @StateRefinement(from="open(this)")
    Enumeration<? extends ZipEntry> entries();

    @StateRefinement(from="open(this)")
    String getComment();
    
    @StateRefinement(from="open(this)")
    ZipEntry getEntry(String name);
    
    @StateRefinement(from="open(this)")
    InputStream getInputStream(ZipEntry entry);
    
    @StateRefinement(from="open(this)")
    int size();
    
    @StateRefinement(from="open(this)")
    Stream<? extends ZipEntry> stream();

        // String getName();//any



}
