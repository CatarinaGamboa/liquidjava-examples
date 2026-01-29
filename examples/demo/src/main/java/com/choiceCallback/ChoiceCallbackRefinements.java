package com.choiceCallback;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@StateSet({"single", "multiple"})
@ExternalRefinementsFor("javax.security.auth.callback.ChoiceCallback")
public interface ChoiceCallbackRefinements {

    @StateRefinement(to="multipleSelectionsAllowed ? multiple(this) : single(this)")
    public void ChoiceCallback(String prompt, String[] choices, int defaultChoice, boolean multipleSelectionsAllowed);
    
    @StateRefinement(from="multiple(this)", to="multiple(this)")
    public void setSelectedIndexes(int[] selections);
}
