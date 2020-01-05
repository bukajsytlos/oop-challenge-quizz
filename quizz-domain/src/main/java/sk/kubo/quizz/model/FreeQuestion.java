package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.argumentNotNull;

import java.util.function.Predicate;

public class FreeQuestion extends Question<String> {
    private Predicate<String> correctAnswerPredicate;

    protected FreeQuestion(String description, Predicate<String> correctAnswerPredicate) {
        super(description);
        this.correctAnswerPredicate = argumentNotNull(correctAnswerPredicate, "correctAnswerPredicate");
    }

    @Override
    public boolean evaluate(String answer) {
        return correctAnswerPredicate.test(answer);
    }
}
