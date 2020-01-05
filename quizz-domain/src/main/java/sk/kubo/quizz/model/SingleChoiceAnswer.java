package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.argumentNotNull;

public class SingleChoiceAnswer extends Answer<SingleChoiceQuestion, QuestionChoice> {

    public SingleChoiceAnswer(SingleChoiceQuestion question, QuestionChoice selectedChoice) {
        super(question, argumentNotNull(selectedChoice, "selectedChoice"));
    }

    @Override
    public boolean isCorrect() {
        return question.evaluate(answer);
    }
}
