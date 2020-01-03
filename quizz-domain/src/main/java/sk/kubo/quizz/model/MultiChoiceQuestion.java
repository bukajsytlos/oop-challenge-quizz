package sk.kubo.quizz.model;

import java.util.List;

public class MultiChoiceQuestion extends Question {
    private List<QuestionChoice> correctAnswers;

    public MultiChoiceQuestion(String text, List<QuestionChoice> answerChoices) {
        super(text, answerChoices);
        this.correctAnswers = super.getCorrectAnswers();
        if (correctAnswers.isEmpty()) {
            throw new IllegalArgumentException("Multi-choice question should have at least on correct choice. Question [" + text + "]");
        }
    }

    @Override
    public List<QuestionChoice> getCorrectAnswers() {
        return correctAnswers;
    }

    @Override
    public Answer<?> acceptQuestionVisitor(QuestionEvaluator questionEvaluator) {
        return questionEvaluator.evaluate(this);
    }
}
