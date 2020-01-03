package sk.kubo.quizz.model;

import static org.assertj.core.util.Preconditions.checkNotNull;

import java.util.Objects;

public class QuestionChoice {
    private String description;
    private boolean isCorrect;

    public QuestionChoice(String description, boolean isCorrect) {
        checkNotNull(description, "QuestionChoice description not provided!");
        this.description = description;
        this.isCorrect = isCorrect;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionChoice)) return false;
        QuestionChoice that = (QuestionChoice) o;
        return getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }
}
