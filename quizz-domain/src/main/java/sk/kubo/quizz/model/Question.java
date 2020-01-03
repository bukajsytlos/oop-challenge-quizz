package sk.kubo.quizz.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Question {
    public static final int MAX_CHOICE_COUNT = 5;
    public static final int MIN_CHOICE_COUNT = 2;
    private String description;
    private List<QuestionChoice> questionChoices;

    protected Question(String description, List<QuestionChoice> questionChoices) {
        if (questionChoices == null || questionChoices.size() < MIN_CHOICE_COUNT || questionChoices.size() > MAX_CHOICE_COUNT) {
            throw new IllegalArgumentException("Question should have at least " + MIN_CHOICE_COUNT + " and max " + MAX_CHOICE_COUNT + " possible answers");
        }
        this.description = description;
        this.questionChoices = questionChoices;
    }

    public String getDescription() {
        return description;
    }

    public List<QuestionChoice> getQuestionChoices() {
        return questionChoices;
    }

    protected List<QuestionChoice> getCorrectAnswers() {
        return questionChoices.stream()
            .filter(QuestionChoice::isCorrect)
            .collect(Collectors.toList());
    }

    public abstract Answer<?> acceptQuestionVisitor(QuestionEvaluator questionEvaluator);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return getDescription().equals(question.getDescription()) &&
            getQuestionChoices().equals(question.getQuestionChoices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getQuestionChoices());
    }
}
