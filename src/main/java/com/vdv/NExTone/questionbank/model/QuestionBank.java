package com.vdv.NExTone.questionbank.model;

import java.util.List;

public record QuestionBank(List<Question> questions) {

    @Override
    public String toString() {
        return "QuestionBank{" +
                "questions=" + questions +
                '}';
    }
}
