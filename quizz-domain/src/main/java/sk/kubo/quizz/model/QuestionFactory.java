package sk.kubo.quizz.model;

import java.util.List;

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
}
