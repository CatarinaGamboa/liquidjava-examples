package com.barista.throwable;

import java.lang.Throwable;

public class ThrowableTest {
    public void test1() {
        Throwable x = new Throwable();
        x.initCause(x);
        x.initCause(x);
    }

    public void test2() {
        Throwable x = new Throwable();
        Throwable y = new Throwable(x);
        x.initCause(y);
    }
}
