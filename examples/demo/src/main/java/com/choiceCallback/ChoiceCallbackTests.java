package com.choiceCallback;

import javax.security.auth.callback.ChoiceCallback;

public class ChoiceCallbackTests {
    
    // not supported
    void example() {
        boolean allowMultipleSelection = false;
        ChoiceCallback cc = new ChoiceCallback(null, null, 0, allowMultipleSelection);
        cc.setSelectedIndexes(null); // error
    }
}
