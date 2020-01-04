package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.argumentNotNull;

public class SingleChoiceAnswer extends Answer<SingleChoiceQuestion> {
    private QuestionChoice selectedChoice;

    public SingleChoiceAnswer(SingleChoiceQuestion question, QuestionChoice selectedChoice) {
        super(question);
        this.selectedChoice = argumentNotNull(selectedChoice, "selectedChoice");
    }

    @Override
    public boolean isCorrect() {
        if (selectedChoice == null) {
            return false;
        }
        return question.getCorrectAnswer().equals(selectedChoice);
    }
}
