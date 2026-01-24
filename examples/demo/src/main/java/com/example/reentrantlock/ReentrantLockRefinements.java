package com.example.reentrantlock;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.util.concurrent.locks.ReentrantLock")
@StateSet({"unlocked", "locked"})
public interface ReentrantLockRefinements {

    @StateRefinement(to="unlocked(this)")
    public void ReentrantLock();

    @StateRefinement(from="unlocked(this)", to="locked(this)")
    public void lock();

    @StateRefinement(from="locked(this)", to="unlocked(this)")
    public void unlock();
}
