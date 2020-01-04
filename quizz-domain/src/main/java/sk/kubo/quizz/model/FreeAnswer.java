package sk.kubo.quizz.model;

public class FreeAnswer extends Answer<FreeQuestion> {
    private String answer;

    public FreeAnswer(FreeQuestion question, String answer) {
        super(question);
        this.answer = answer;
    }

    @Override
    public boolean isCorrect() {
        return question.isCorrect(answer);
    }
}
