package com.example.uuid;

import java.util.UUID;

public class UUIDTest {
    void test1fail() {
        UUID u = UUID.randomUUID();
        u.timestamp(); // should report an error, because u is not time-based
    }
    void test2fail(UUID u) {
        u.clockSequence(); // should report an error, because u may not be time-based
    }
    void test3(UUID u) {
        if (u.version() == 1) {
            u.node(); // should be OK, because u is time-based
        }
    }
    void test4fail(UUID u) {
        if (u.version() == 2) {
            u.timestamp(); // should report an error, because u is not time-based -- but I don't get an error.
        }
    }
}
