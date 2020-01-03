package sk.kubo.quizz.model;

import java.util.List;

public class QuizzResult {
    private Quizz quizz;
    private List<Answer<?>> answers;

    public QuizzResult(Quizz quizz, List<Answer<?>> answers) {
        this.quizz = quizz;
        this.answers = answers;
        answers.stream()
            .filter(answer -> !quizz.getQuestions().contains(answer.getQuestion()))
            .findFirst()
            .ifPresent(invalidAnswer -> {
                throw new IllegalArgumentException("Result contains answer for question which is not part of quizz [" + quizz.getName() + "]. Question [" + invalidAnswer.getQuestion().getDescription() + "]");
            });
    }

    public int correctAnswersCount() {
        return (int) answers.stream()
            .filter(Answer::isCorrect)
            .count();
    }

    public int totalQuestionsCount() {
        return quizz.getQuestions().size();
    }
}
