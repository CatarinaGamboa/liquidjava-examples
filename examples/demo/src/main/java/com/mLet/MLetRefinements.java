package com.mLet;

import java.net.URL;
import java.net.URLStreamHandlerFactory;
import java.util.Set;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.management.loading.MLet")
@StateSet({"unregistered", "registered"})
public interface MLetRefinements {
    
    @StateRefinement(to="unregistered(this)")
    public void MLet();

    @StateRefinement(to="unregistered(this)")
    public void MLet(URL[] urls);

    @StateRefinement(to="unregistered(this)")
    public void MLet(URL[] urls, ClassLoader parent);

    @StateRefinement(to="unregistered(this)")
    public void MLet(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory);

    @StateRefinement(to="unregistered(this)")
    public void MLet(URL[] urls, boolean delegateToCLR);

    @StateRefinement(to="unregistered(this)")
    public void MLet(URL[] urls, ClassLoader parent, boolean delegateToCLR);

    @StateRefinement(to="unregistered(this)")
    public void MLet(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory, boolean delegateToCLR);

    // cant write "registrationDone ? registered(this) : unregistered(this)"" because it uses Boolean instead of boolean
    @StateRefinement(from="unregistered(this)", to="registered(this)") 
    public void postRegister(Boolean registrationDone);

    @StateRefinement(from="registered(this)")
    public void preDeregister();

    @StateRefinement(from="registered(this)", to="unregistered(this)")
    public void postDeregister();

    @StateRefinement(from="registered(this)")
    public Set<Object> getMBeansFromURL(URL url);

    @StateRefinement(from="registered(this)")
    public Set<Object> getMBeansFromURL(String url);
}
