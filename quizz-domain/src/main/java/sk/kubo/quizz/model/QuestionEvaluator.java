package sk.kubo.quizz.model;

public interface QuestionEvaluator {
    SingleChoiceAnswer evaluate(SingleChoiceQuestion question);
    MultiChoiceAnswer evaluate(MultiChoiceQuestion question);
    FreeAnswer evaluate(FreeQuestion question);
    Answer<?, ?> evaluate(Question<?> question);
}
