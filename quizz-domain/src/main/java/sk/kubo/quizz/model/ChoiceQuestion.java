package sk.kubo.quizz.model;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ChoiceQuestion extends Question {
    public static final int MAX_CHOICE_COUNT = 5;
    public static final int MIN_CHOICE_COUNT = 2;

    private List<QuestionChoice> questionChoices;

    protected ChoiceQuestion(String description, List<QuestionChoice> questionChoices) {
        super(description);
        if (questionChoices == null || questionChoices.size() < MIN_CHOICE_COUNT || questionChoices.size() > MAX_CHOICE_COUNT) {
            throw new IllegalArgumentException("Question should have at least " + MIN_CHOICE_COUNT + " and max " + MAX_CHOICE_COUNT + " possible answers");
        }
        this.questionChoices = questionChoices;
    }

    public List<QuestionChoice> getQuestionChoices() {
        return questionChoices;
    }

    protected List<QuestionChoice> getCorrectAnswers() {
        return questionChoices.stream()
            .filter(QuestionChoice::isCorrect)
            .collect(Collectors.toList());
    }
}
