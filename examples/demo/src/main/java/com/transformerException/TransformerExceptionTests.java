package com.transformerException;

import javax.xml.transform.TransformerException;

public class TransformerExceptionTests {
    
    public void cannotInvokeInitCauseMoreThanOnce() {
        TransformerException te = new TransformerException("");
        Throwable th = new Throwable();
        te.initCause(th);
        te.initCause(th); // error
    }
}
