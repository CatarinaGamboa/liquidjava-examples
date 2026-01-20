package com.barista.choicecallback;


import liquidjava.specification.StateSet;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.ExternalRefinementsFor;

@StateSet({"singleSelection", "multiSelection",})
@ExternalRefinementsFor("javax.security.auth.callback.ChoiceCallback")
public interface ChoiceCallbackRefinements {
    
    @StateRefinement(to="!multipleSelectionsAllowed --> singleSelection(this) && multipleSelectionsAllowed --> multiSelection(this)")
    public void ChoiceCallback(String prompt, String[] choices, int defaultChoice, boolean multipleSelectionsAllowed);

    @StateRefinement(from="multiSelection(this)", to="multiSelection(this)")
    public void setSelectedIndexes(int[] selections);
}
