package com.barista.xmlfilterimpl;

import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.helpers.XMLFilterImpl;

public class XMLFilterImplTest {
    
    public void test1() throws SAXNotRecognizedException, SAXNotSupportedException {
        XMLFilterImpl xml = new XMLFilterImpl();
        xml.setProperty("key", null);
    }

    public void test2() throws SAXNotRecognizedException, SAXNotSupportedException {
        XMLFilterImpl xml = new XMLFilterImpl(null);
        xml.setProperty("key", null);
    }
}
