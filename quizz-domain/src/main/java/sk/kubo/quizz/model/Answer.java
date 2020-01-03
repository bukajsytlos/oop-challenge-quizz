package sk.kubo.quizz.model;

public abstract class Answer<T extends Question> {
    protected T question;

    public Answer(T question) {
        this.question = question;
    }

    public abstract boolean isCorrect();

    public T getQuestion() {
        return question;
    }
}
