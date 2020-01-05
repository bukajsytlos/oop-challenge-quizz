package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.collectionNotEmpty;

import java.util.List;

public class MultiChoiceAnswer extends Answer<MultiChoiceQuestion, List<QuestionChoice>> {
    public MultiChoiceAnswer(MultiChoiceQuestion question, List<QuestionChoice> selectedChoices) {
        super(question, collectionNotEmpty(selectedChoices, "selectedChoices"));
    }

    @Override
    public boolean isCorrect() {
        return question.evaluate(answer);
    }
}
