package sk.kubo.quizz.model;

import java.util.List;
import java.util.function.Predicate;

public class QuestionFactory {
    private QuestionFactory() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static MultiChoiceQuestion createMultiChoiceQuestion(String text, List<QuestionChoice> answerChoices) {
        return new MultiChoiceQuestion(text, answerChoices);
    }

    public static SingleChoiceQuestion createSingleChoiceQuestion(String text, List<QuestionChoice> answerChoices) {
        return new SingleChoiceQuestion(text, answerChoices);
    }

    public static FreeQuestion createFreeQuestion(String text, Predicate<String> correctAnswerPredicate) {
        return new FreeQuestion(text, correctAnswerPredicate);
    }
}
