package sk.kubo.quizz.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FreeAnswerTest {

    @Test
    void correctAnswerText_shouldBeCorrect() {
        assertThat(AnswerFixture.CORRECT_FREE_ANSWER.isCorrect()).isTrue();
    }

    @Test
    void inCorrectAnswerText_shouldBeIncorrect() {
        assertThat(AnswerFixture.INCORRECT_FREE_ANSWER.isCorrect()).isFalse();
    }
}