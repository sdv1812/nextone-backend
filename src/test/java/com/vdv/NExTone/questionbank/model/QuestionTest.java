package com.vdv.NExTone.questionbank.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void equalsHandlesNullIds() {
        Question q1 = new Question(null, 1, "question", List.of(), null);
        Question q2 = new Question(null, 1, "question", List.of(), null);
        assertDoesNotThrow(() -> q1.equals(q2));
        assertEquals(q1, q2);
    }

    @Test
    void notEqualsWhenQuestionNumberDiffers() {
        Question q1 = new Question(null, 1, "question", List.of(), null);
        Question q2 = new Question(null, 2, "question", List.of(), null);
        assertNotEquals(q1, q2);
    }
}
