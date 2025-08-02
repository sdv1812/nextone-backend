package com.vdv.NExTone.questionbank.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionTest {

    @Test
    void equalsHandlesNullIds() {
        Option o1 = new Option(null, "A");
        Option o2 = new Option(null, "A");
        assertDoesNotThrow(() -> o1.equals(o2));
        assertEquals(o1, o2);
    }
}
