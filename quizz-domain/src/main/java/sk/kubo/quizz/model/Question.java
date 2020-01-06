package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.argumentIsValue;

import java.util.Objects;

public abstract class Question<ANSWER_TYPE> {
    private final String description;

    protected Question(String description) {
        this.description = argumentIsValue(description, "description");
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean evaluate(ANSWER_TYPE answer);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question<?> question = (Question<?>) o;
        return getDescription().equals(question.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }
}
