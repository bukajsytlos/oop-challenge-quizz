package sk.kubo.quizz.model;

public class SingleChoiceAnswer extends Answer<SingleChoiceQuestion> {
    private QuestionChoice selectedChoice;

    public SingleChoiceAnswer(SingleChoiceQuestion question, QuestionChoice selectedChoice) {
        super(question);
        this.selectedChoice = selectedChoice;
    }

    @Override
    public boolean isCorrect() {
        if (selectedChoice == null) {
            return false;
        }
        return question.getCorrectAnswer().equals(selectedChoice);
    }
}
