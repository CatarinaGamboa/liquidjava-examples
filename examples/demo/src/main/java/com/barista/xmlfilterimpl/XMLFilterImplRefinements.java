package com.barista.xmlfilterimpl;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import liquidjava.specification.StateSet;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.ExternalRefinementsFor;

@StateSet({"parentless", "withparent"})
@ExternalRefinementsFor("org.xml.sax.helpers.XMLFilterImpl")
public interface XMLFilterImplRefinements {
    // Constructors
    @StateRefinement(to="parentless(this)")
    public void XMLFilterImpl();

    @StateRefinement(to="withparent(this)")
    public void XMLFilterImpl(XMLReader parent);

    // Methods
    @StateRefinement(from="parentless(this) || withparent(this)", to="withparent(this)")
    public void setParent(XMLReader parent);

    @StateRefinement(from="withparent(this)", to="withparent(this)")
    public void setProperty(String name, Object value);

    @StateRefinement(from="withparent(this)", to="withparent(this)")
    public Object getProperty(String name);

    @StateRefinement(from="withparent(this)", to="withparent(this)")
    public void setFeature(String name, boolean value);

    @StateRefinement(from="withparent(this)", to="withparent(this)")
    public boolean getFeature(String name);

    @StateRefinement(from="withparent(this)", to="withparent(this)")
    public void parse(InputSource input);

    @StateRefinement(from="withparent(this)", to="withparent(this)")
    public void parse(String systemId);
}
