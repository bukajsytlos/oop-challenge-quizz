package sk.kubo.quizz.model;

import java.util.Objects;

public abstract class Question {
    private String description;

    protected Question(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract Answer<?> acceptQuestionVisitor(QuestionEvaluator questionEvaluator);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return getDescription().equals(question.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }
}
