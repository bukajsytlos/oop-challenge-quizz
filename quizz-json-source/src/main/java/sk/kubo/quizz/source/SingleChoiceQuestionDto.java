package sk.kubo.quizz.source;

import java.util.stream.Collectors;

import sk.kubo.quizz.model.SingleChoiceQuestion;

public class SingleChoiceQuestionDto extends QuestionDto {
    @Override
    public SingleChoiceQuestion asQuestion() {
        return new SingleChoiceQuestion(description, questionChoices.stream().map(QuestionChoiceDto::asQuestionChoice).collect(Collectors.toList()));
    }
}
