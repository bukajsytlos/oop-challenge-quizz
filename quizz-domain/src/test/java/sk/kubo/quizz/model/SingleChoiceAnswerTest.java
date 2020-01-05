package sk.kubo.quizz.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class SingleChoiceAnswerTest {
    @Test
    void createAnswer_withoutChoice_shouldFail() {
        assertThatIllegalArgumentException().isThrownBy(() -> new SingleChoiceAnswer(QuestionFixture.SINGLE_CHOICE_QUESTION, null));
    }

    @Test
    void answerWithCorrectChoice_shouldBeCorrect() {
        assertThat(AnswerFixture.CORRECT_SINGLE_CHOICE_ANSWER.isCorrect()).isTrue();
    }

    @Test
    void answerWithIncorrectChoice_shouldBeIncorrect() {
        assertThat(AnswerFixture.INCORRECT_SINGLE_CHOICE_ANSWER.isCorrect()).isFalse();
    }
}