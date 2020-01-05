package sk.kubo.quizz.model;

public class QuizzFixture {
    static final Quizz QUIZZ = new Quizz.Builder("Test quizz")
        .addQuestion(QuestionFixture.FREE_QUESTION)
        .addQuestion(QuestionFixture.SINGLE_CHOICE_QUESTION)
        .addQuestion(QuestionFixture.MULTI_CHOICE_QUESTION)
        .build();
}
