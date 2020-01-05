package sk.kubo.quizz.model;

import java.util.List;

public class QuestionFixture {
    static final FreeQuestion FREE_QUESTION = QuestionFactory.createFreeQuestion("How do you do?", answer -> answer.contains("fine"));
    static final QuestionChoice FIRST_CORRECT_CHOICE = new QuestionChoice("2", true);
    static final QuestionChoice SECOND_CORRECT_CHOICE = new QuestionChoice("2^1", true);
    static final QuestionChoice INCORRECT_CHOICE = new QuestionChoice("1", false);
    static final SingleChoiceQuestion SINGLE_CHOICE_QUESTION = QuestionFactory.createSingleChoiceQuestion(
        "1+1=",
        List.of(FIRST_CORRECT_CHOICE, INCORRECT_CHOICE)
    );
    static final MultiChoiceQuestion MULTI_CHOICE_QUESTION = QuestionFactory.createMultiChoiceQuestion(
        "1+1=",
        List.of(FIRST_CORRECT_CHOICE, SECOND_CORRECT_CHOICE, INCORRECT_CHOICE)
    );


}
