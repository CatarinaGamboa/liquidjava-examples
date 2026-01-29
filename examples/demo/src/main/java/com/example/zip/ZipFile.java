package com.example.zip;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;


/*
State machine:

closed

^ close

opened.  @ getEntry, getIS, stream, entries

*/

@ExternalRefinementsFor("java.util.zip.ZipFile")
@StateSet({"opened", "closed"})
public interface ZipFile {
	
	@StateRefinement(to="opened(this)")
	public void ZipFile(File file);

    @StateRefinement(to="opened(this)")
	public void ZipFile(File file, int mode);

    @StateRefinement(to="opened(this)")
	public void ZipFile(File file, int mode, Charset cs);

    @StateRefinement(to="opened(this)")
	public void ZipFile(File file, Charset cs);

    @StateRefinement(to="opened(this)")
	public void ZipFile(String name);

    @StateRefinement(to="opened(this)")
	public void ZipFile(String name, Charset cs);

    @StateRefinement(from="opened(this)", to="closed(this)")
    public void close();

    @StateRefinement(from="opened(this)")
    public Enumeration<? extends ZipEntry> entries();

    @StateRefinement(from="opened(this)")
    public ZipEntry getEntry(String name);

    @StateRefinement(from="opened(this)")
    public InputStream getInputStream(ZipEntry e);


}
