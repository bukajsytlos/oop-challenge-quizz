package sk.kubo.quizz.model;

public interface QuestionEvaluator {
    Answer<?> evaluate(SingleChoiceQuestion question);
    Answer<?> evaluate(MultiChoiceQuestion question);
    Answer<?> evaluate(Question question);
}
