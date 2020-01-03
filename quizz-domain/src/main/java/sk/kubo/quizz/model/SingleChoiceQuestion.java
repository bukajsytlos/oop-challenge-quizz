package sk.kubo.quizz.model;

import java.util.List;

public class SingleChoiceQuestion extends Question {
    private QuestionChoice correctAnswer;

    public SingleChoiceQuestion(String text, List<QuestionChoice> answerChoices) {
        super(text, answerChoices);
        final List<QuestionChoice> correctAnswers = getCorrectAnswers();
        if (correctAnswers.size() != 1) {
            throw new IllegalArgumentException("Single choice question should have only one correct answer. Question [" + text + "]");
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
