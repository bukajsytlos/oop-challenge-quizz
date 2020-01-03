package sk.kubo.quizz.model;

public class NoAnswer extends Answer<Question> {
    public NoAnswer(Question question) {
        super(question);
    }

    @Override
    public boolean isCorrect() {
        return false;
    }
}
