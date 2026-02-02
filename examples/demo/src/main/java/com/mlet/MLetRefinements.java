package com.mlet;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.net.URLStreamHandlerFactory;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.loading.ClassLoaderRepository;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.management.loading.MLet")
@StateSet({"start", "preRegistered", "registered", "preDeregistered"})
public interface MLetRefinements {

    @StateRefinement(to="start(this)")
    void MLet();
    @StateRefinement(to="start(this)")
    void MLet(URL[] urls);
    @StateRefinement(to="start(this)")
    void MLet(URL[] urls, boolean delegateToCLR);
    @StateRefinement(to="start(this)")
    void MLet(URL[] urls, ClassLoader parent);
    @StateRefinement(to="start(this)")
    void MLet(URL[] urls, ClassLoader parent, boolean delegateToCLR);
    @StateRefinement(to="start(this)")
    void MLet(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory);
    @StateRefinement(to="start(this)")
    void MLet(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory, boolean delegateToCLR);


    @StateRefinement(from="start(this)", to="preRegistered(this)")
    ObjectName preRegister(MBeanServer server, ObjectName name);
    @StateRefinement(from="preRegistered(this)", to="registered(this)")
    void postRegister(Boolean registrationDone);
    @StateRefinement(from="registered(this)", to="preDeregistered(this)")
    void preDeregister();
    @StateRefinement(from="preDeregistered(this)", to="start(this)")
    void postDeregister();

    @StateRefinement(from="registered(this)")
    Set<Object> getMBeansFromURL(String url);
    @StateRefinement(from="registered(this)")
    Set<Object> getMBeansFromURL(URL url);


    // void addURL(String url);
    // void addURL(URL url);
    // String getLibraryDirectory();

    // URL[] getURLs();
    // Class<?> loadClass(String name, ClassLoaderRepository clr);
    // void readExternal(ObjectInput in);
    // void setLibraryDirectory(String libdir);
    // void writeExternal(ObjectOutput out);

}
