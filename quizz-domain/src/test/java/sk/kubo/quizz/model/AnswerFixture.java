package sk.kubo.quizz.model;

import java.util.List;

public class AnswerFixture {
    static final FreeAnswer CORRECT_FREE_ANSWER = new FreeAnswer(QuestionFixture.FREE_QUESTION, "I am fine");
    static final FreeAnswer INCORRECT_FREE_ANSWER = new FreeAnswer(QuestionFixture.FREE_QUESTION, "Life sucks");

    static final SingleChoiceAnswer CORRECT_SINGLE_CHOICE_ANSWER = new SingleChoiceAnswer(QuestionFixture.SINGLE_CHOICE_QUESTION, QuestionFixture.FIRST_CORRECT_CHOICE);
    static final SingleChoiceAnswer INCORRECT_SINGLE_CHOICE_ANSWER = new SingleChoiceAnswer(QuestionFixture.SINGLE_CHOICE_QUESTION, QuestionFixture.INCORRECT_CHOICE);

    static final MultiChoiceAnswer CORRECT_MULTI_CHOICE_ANSWER = new MultiChoiceAnswer(QuestionFixture.MULTI_CHOICE_QUESTION, List.of(QuestionFixture.FIRST_CORRECT_CHOICE, QuestionFixture.SECOND_CORRECT_CHOICE));
    static final MultiChoiceAnswer PARTIALLY_CORRECT_MULTI_CHOICE_ANSWER = new MultiChoiceAnswer(QuestionFixture.MULTI_CHOICE_QUESTION, List.of(QuestionFixture.FIRST_CORRECT_CHOICE));
    static final MultiChoiceAnswer INCORRECT_MULTI_CHOICE_ANSWER = new MultiChoiceAnswer(QuestionFixture.MULTI_CHOICE_QUESTION, List.of(QuestionFixture.INCORRECT_CHOICE));
}
