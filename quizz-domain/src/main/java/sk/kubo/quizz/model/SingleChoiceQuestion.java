package sk.kubo.quizz.model;

import java.util.List;

public class SingleChoiceQuestion extends ChoiceQuestion<QuestionChoice> {
    private QuestionChoice correctAnswer;

    public SingleChoiceQuestion(String description, List<QuestionChoice> answerChoices) {
        super(description, answerChoices);
        final List<QuestionChoice> correctAnswers = getCorrectAnswers();
        if (correctAnswers.size() != 1) {
            throw new IllegalArgumentException("Single choice question should have only one correct answer. Question [" + description + "]");
        }
        this.correctAnswer = correctAnswers.stream().findFirst().orElseThrow();
    }

    @Override
    public boolean evaluate(QuestionChoice answer) {
        if (answer == null) {
            return false;
        }
        return correctAnswer.equals(answer);
    }
}
