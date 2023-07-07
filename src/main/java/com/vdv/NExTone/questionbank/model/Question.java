package com.vdv.NExTone.questionbank.model;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

public record Question(
        @Id
        String id,
        Integer questionNumber,
        String questionText,
        List<Option> options,
        Option correctOption) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id.equals(question.id) && questionNumber.equals(question.questionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionNumber);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionNumber=" + questionNumber +
                ", questionText='" + questionText + '\'' +
                ", options=" + options +
                ", correctOption=" + correctOption +
                '}';
    }
}
