package com.uuid;

import java.util.UUID;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
// 0x000000000000F000
// (v/4096) % 16;

@ExternalRefinementsFor("java.util.UUID")
@StateSet({"other", "maybeTime", "timeBased"})
@RefinementAlias("Version(int v) {v >= 0 && v <= 4}")
@RefinementAlias("Variant(int v) {v == 0 || v == 2 || v == 6 || v == 7}")
public interface UUIDRefinements {

    // creation
    @StateRefinement(to="((mostSigBits/4096) % 16 == 1) ? timeBased(this) : other(this)") 
    void UUID(long mostSigBits, long leastSigBits);

    //static
    @Refinement("maybeTime(return)")
    UUID fromString(String name);

    //static 
    @Refinement("other(return)")
    UUID nameUUIDFromBytes(byte[] name);

    //static
    @Refinement("other(return)") 
    UUID randomUUID();

    
    @StateRefinement(from="maybeTime(this)")
    @StateRefinement(from="timeBased(this)")
    int clockSequence();
    
    @StateRefinement(from="maybeTime(this)")
    @StateRefinement(from="timeBased(this)")
    long timestamp();
    
    @StateRefinement(from="maybeTime(this)")
    @StateRefinement(from="timeBased(this)")
    long node();
    
    @Refinement("Variant(_)")
    int variant();
    @Refinement("Version(_)")
    int version();

    // int compareTo(UUID val);
    // boolean equals(Object obj);
    // long getLeastSignificantBits();
    // long getMostSignificantBits();
    // int hashCode();
    // String toString();

}
