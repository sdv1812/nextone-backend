package com.vdv.NExTone.questionbank.model;

import java.util.Objects;

public class Option {
    private final Long optionId;

    private final String option;

    private String comment;

    public Option(Long optionId, String option) {
        this.optionId = optionId;
        this.option = option;
    }

    public Long getOptionId() {
        return optionId;
    }

    public String getOption() {
        return option;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option1 = (Option) o;
        return optionId.equals(option1.optionId) && option.equals(option1.option) && Objects.equals(comment, option1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optionId, option, comment);
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionId=" + optionId +
                ", option='" + option + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
