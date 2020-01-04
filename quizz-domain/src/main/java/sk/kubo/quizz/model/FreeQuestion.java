package sk.kubo.quizz.model;

import java.util.function.Predicate;

public class FreeQuestion extends Question {
    private Predicate<String> correctAnswerPredicate;

    protected FreeQuestion(String description, Predicate<String> correctAnswerPredicate) {
        super(description);
        this.correctAnswerPredicate = correctAnswerPredicate;
    }

    @Override
    public Answer<?> acceptQuestionVisitor(QuestionEvaluator questionEvaluator) {
        return questionEvaluator.evaluate(this);
    }

    public boolean isCorrect(String answerValue) {
        return correctAnswerPredicate.test(answerValue);
    }
}
