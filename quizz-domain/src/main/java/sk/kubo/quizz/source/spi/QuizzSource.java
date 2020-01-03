package sk.kubo.quizz.source.spi;

import java.util.List;

import sk.kubo.quizz.model.Quizz;

public interface QuizzSource {
    List<Quizz> getQuizzes();
}
