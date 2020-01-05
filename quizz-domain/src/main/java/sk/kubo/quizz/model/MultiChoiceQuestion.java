package sk.kubo.quizz.model;

import java.util.List;
import java.util.stream.Collectors;

public class MultiChoiceQuestion extends ChoiceQuestion<List<QuestionChoice>> {
    private List<QuestionChoice> correctAnswers;

    public MultiChoiceQuestion(String description, List<QuestionChoice> answerChoices) {
        super(description, answerChoices);
        this.correctAnswers = answerChoices.stream()
            .filter(QuestionChoice::isCorrect)
            .collect(Collectors.toList());
        if (correctAnswers.isEmpty()) {
            throw new IllegalArgumentException("Multi-choice question should have at least one correct choice. Question [" + description + "]");
        }
    }

    public boolean evaluate(List<QuestionChoice> choices) {
        if (choices.isEmpty()) {
            return false;
        }
        return choices.containsAll(correctAnswers);
    }

    @Override
    public MultiChoiceAnswer acceptQuestionVisitor(QuestionEvaluator questionEvaluator) {
        return questionEvaluator.evaluate(this);
    }
}
