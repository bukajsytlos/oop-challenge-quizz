package sk.kubo.quizz.source;

import java.util.List;

import sk.kubo.quizz.model.Quizz;

public class QuizzDto {
    public String name;
    public List<QuestionDto> questions;

    public Quizz asQuizz() {
        final Quizz.Builder builder = new Quizz.Builder(name);
        for (QuestionDto question : questions) {
            builder.addQuestion(question.asQuestion());
        }
        return builder.build();
    }
}
