package com.example.uuid;

import java.util.UUID;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.util.UUID")
@StateSet({"time_based", "dce_security", "name_based", "random"})
public interface UUIDRefinements {
    //@StateRefinement(from="leastSigBits & 0xC000000000000000 == 0xB000000000000000 && mostSigBits & 0x000000000000F000 == 0x0000000000001000", to="time_based(this)")
    public void UUID(long mostSigBits, long leastSigBits);

    // QUESTION: is this how static methods should be specified?
    @Refinement("random(_)")
    public UUID randomUUID();

    @Refinement("name_based(_)")
    public UUID nameUUIDFromBytes(byte[] name);

    @Refinement("_ == 1 && time_based(this) || _ == 2 && dce_security(this) || _ == 3 && name_based(this) || _ == 4 && random(this)")
    public int version();

    @StateRefinement(from="time_based(this)")
    public long timestamp();

    @StateRefinement(from="time_based(this)")
    public int clockSequence();

    @StateRefinement(from="time_based(this)")
    public long node();
}
