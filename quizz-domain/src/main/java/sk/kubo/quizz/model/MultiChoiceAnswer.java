package sk.kubo.quizz.model;

import java.util.Collections;
import java.util.List;

public class MultiChoiceAnswer extends Answer<MultiChoiceQuestion> {
    private List<QuestionChoice> selectedChoices;

    public MultiChoiceAnswer(MultiChoiceQuestion question, List<QuestionChoice> selectedChoices) {
        super(question);
        this.selectedChoices = selectedChoices != null ? selectedChoices : Collections.emptyList();
    }

    @Override
    public boolean isCorrect() {
        if (selectedChoices.isEmpty()) {
            return false;
        }
        return selectedChoices.containsAll(question.getCorrectAnswers());
    }
}
