package sk.kubo.quizz.source;

import sk.kubo.quizz.model.QuestionChoice;

public class QuestionChoiceDto {
    public String description;
    public boolean isCorrect;

    public QuestionChoice asQuestionChoice() {
        return new QuestionChoice(description, isCorrect);
    }
}
