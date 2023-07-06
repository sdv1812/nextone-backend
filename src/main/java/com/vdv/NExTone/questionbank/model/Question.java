package com.vdv.NExTone.questionbank.model;

import java.util.List;
import java.util.Objects;

public record Question(Long questionId, Integer questionNumber, String questionText, List<Option> options,
                       Option correctOption) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return questionId.equals(question.questionId) && questionNumber.equals(question.questionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, questionNumber);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionNumber=" + questionNumber +
                ", questionText='" + questionText + '\'' +
                ", options=" + options +
                ", correctOption=" + correctOption +
                '}';
    }
}
