package com.vdv.NExTone.questionbank.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Option {
    @Id
    private final String id;

    private final String option;

    private String comment;

    public Option(String id, String option) {
        this.id = id;
        this.option = option;
    }

    public String getId() {
        return id;
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
        return id.equals(option1.id) && option.equals(option1.option) && Objects.equals(comment, option1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, option, comment);
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionId=" + id +
                ", option='" + option + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
