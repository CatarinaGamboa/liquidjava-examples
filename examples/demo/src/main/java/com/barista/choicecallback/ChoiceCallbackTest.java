package com.barista.choicecallback;

import javax.security.auth.callback.ChoiceCallback;

public class ChoiceCallbackTest {
    public void test1() {
        ChoiceCallback x = new ChoiceCallback(null, null, 0, true);
        x.setSelectedIndexes(null);
    }   
    public void test2() {
        ChoiceCallback x = new ChoiceCallback(null, null, 0, false);
        x.setSelectedIndexes(null);
    }   
}
