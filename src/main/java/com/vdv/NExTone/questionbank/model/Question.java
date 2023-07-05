package com.vdv.NExTone.questionbank.model;

import java.util.List;
import java.util.Objects;

public class Question {
    private final Long questionId;

    private final Integer questionNumber;

    private final List<Option> options;

    private final Option correctOption;

    public Question(Long questionId, Integer questionNumber, List<Option> options, Option correctOption) {
        this.questionId = questionId;
        this.questionNumber = questionNumber;
        this.options = options;
        this.correctOption = correctOption;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public List<Option> getOptions() {
        return options;
    }

    public Option getCorrectOption() {
        return correctOption;
    }

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
}
