package sk.kubo.quizz.source;

import java.util.stream.Collectors;

import sk.kubo.quizz.model.MultiChoiceQuestion;

public class MultiChoiceQuestionDto extends QuestionDto {
    @Override
    public MultiChoiceQuestion asQuestion() {
        return new MultiChoiceQuestion(description, questionChoices.stream().map(QuestionChoiceDto::asQuestionChoice).collect(Collectors.toList()));
    }
}
