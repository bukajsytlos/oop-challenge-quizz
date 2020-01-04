package sk.kubo.quizz.model;

import java.util.List;

public class SingleChoiceQuestion extends ChoiceQuestion {
    private QuestionChoice correctAnswer;

    public SingleChoiceQuestion(String description, List<QuestionChoice> answerChoices) {
        super(description, answerChoices);
        final List<QuestionChoice> correctAnswers = getCorrectAnswers();
        if (correctAnswers.size() != 1) {
            throw new IllegalArgumentException("Single choice question should have only one correct answer. Question [" + description + "]");
        }
        this.correctAnswer = correctAnswers.stream().findFirst().orElseThrow();
    }

    public QuestionChoice getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public Answer<?> acceptQuestionVisitor(QuestionEvaluator questionEvaluator) {
        return questionEvaluator.evaluate(this);
    }
}
