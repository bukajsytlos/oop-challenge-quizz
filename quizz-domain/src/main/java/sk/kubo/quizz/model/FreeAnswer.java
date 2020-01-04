package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.argumentNotNull;

public class FreeAnswer extends Answer<FreeQuestion> {
    private String answer;

    public FreeAnswer(FreeQuestion question, String answer) {
        super(question);
        this.answer = argumentNotNull(answer, "answer");
    }

    @Override
    public boolean isCorrect() {
        return question.isCorrect(answer);
    }
}
