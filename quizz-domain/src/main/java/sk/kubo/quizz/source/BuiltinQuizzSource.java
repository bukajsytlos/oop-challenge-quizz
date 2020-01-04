package sk.kubo.quizz.source;

import java.util.List;

import sk.kubo.quizz.model.QuestionChoice;
import sk.kubo.quizz.model.QuestionFactory;
import sk.kubo.quizz.model.Quizz;
import sk.kubo.quizz.source.spi.QuizzSource;

public class BuiltinQuizzSource implements QuizzSource {
    @Override
    public List<Quizz> getQuizzes() {
        return List.of(
            new Quizz.Builder("Math quizz 1")
                .addQuestion(QuestionFactory.createMultiChoiceQuestion(
                    "2 + 2 = ",
                    List.of(
                        new QuestionChoice("4", true),
                        new QuestionChoice("2^2", true),
                        new QuestionChoice("6", false)
                    )
                ))
                .addQuestion(QuestionFactory.createSingleChoiceQuestion(
                    "3 * 3 = ",
                    List.of(
                        new QuestionChoice("9", true),
                        new QuestionChoice("vela", false)
                    )
                ))
                .addQuestion(QuestionFactory.createSingleChoiceQuestion(
                    "Choose max value",
                    List.of(
                        new QuestionChoice("1900500", true),
                        new QuestionChoice("3 * 630340", false)
                    )
                ))
                .addQuestion(QuestionFactory.createLenientQuestion(
                    "There are 5 birds on the tree. You shot 2 of them. How many are left?",
                    answer -> answer.contains("none")
                ))
                .build()
        );
    }

}
