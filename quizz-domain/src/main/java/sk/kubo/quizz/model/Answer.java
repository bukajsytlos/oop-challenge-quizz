package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.argumentNotNull;

public abstract class Answer<T extends Question> {
    protected T question;

    public Answer(T question) {
        this.question = argumentNotNull(question, "question");
    }

    public abstract boolean isCorrect();

    public T getQuestion() {
        return question;
    }
}
