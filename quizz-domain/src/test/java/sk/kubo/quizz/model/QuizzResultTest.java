package sk.kubo.quizz.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class QuizzResultTest {

    @Test
    void quizzResult_withThreeQuestions_shouldHaveThreeQuestionsCount() {
        final QuizzResult quizzResult = new QuizzResult(QuizzFixture.QUIZZ, Collections.emptyList());
        assertThat(quizzResult.totalQuestionsCount()).isEqualTo(3);
    }

    @Test
    void quizzResult_withoutAnswers_shouldHaveZeroCorrectAnswerCount() {
        final QuizzResult quizzResult = new QuizzResult(QuizzFixture.QUIZZ, Collections.emptyList());
        assertThat(quizzResult.correctAnswersCount()).isEqualTo(0);
    }

    @Test
    void quizzResult_withThreeCorrectAnswers_shouldHaveThreeCorrectAnswerCount() {
        final QuizzResult quizzResult = new QuizzResult(QuizzFixture.QUIZZ, List.of(
            AnswerFixture.CORRECT_FREE_ANSWER,
            AnswerFixture.CORRECT_SINGLE_CHOICE_ANSWER,
            AnswerFixture.CORRECT_MULTI_CHOICE_ANSWER
        ));
        assertThat(quizzResult.correctAnswersCount()).isEqualTo(3);
    }
}