package sk.kubo.quizz.model;

@SuppressWarnings({"unchecked", "rawtypes"})
public class NoAnswer extends Answer {
    public NoAnswer(Question<?> question) {
        super(question, null);
    }

    @Override
    public boolean isCorrect() {
        return false;
    }
}
