package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.argumentNotNull;

public class FreeAnswer extends Answer<FreeQuestion, String> {
    public FreeAnswer(FreeQuestion question, String answer) {
        super(question, argumentNotNull(answer, "answer"));
    }

    @Override
    public boolean isCorrect() {
        return question.evaluate(answer);
    }
}
