package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.argumentNotNull;

public abstract class Answer<T extends Question<ANSWER_TYPE>, ANSWER_TYPE> {
    protected final T question;
    protected final ANSWER_TYPE answer;

    public Answer(T question, ANSWER_TYPE answer) {
        this.question = argumentNotNull(question, "question");
        this.answer = answer;
    }

    public abstract boolean isCorrect();

    public T getQuestion() {
        return question;
    }
}
