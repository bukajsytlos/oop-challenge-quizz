package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.argumentIsValue;

import java.util.Objects;

public class QuestionChoice {
    private final String description;
    private final boolean isCorrect;

    public QuestionChoice(String description, boolean isCorrect) {
        this.description = argumentIsValue(description, "description");
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
