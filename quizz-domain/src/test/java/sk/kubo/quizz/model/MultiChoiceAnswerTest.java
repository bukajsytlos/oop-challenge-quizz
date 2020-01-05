package sk.kubo.quizz.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Collections;

import org.junit.jupiter.api.Test;

class MultiChoiceAnswerTest {
    
    @Test
    void createAnswer_withoutChoice_shouldFail() {
        assertThatIllegalArgumentException().isThrownBy(() -> new MultiChoiceAnswer(QuestionFixture.MULTI_CHOICE_QUESTION, null));
        assertThatIllegalArgumentException().isThrownBy(() -> new MultiChoiceAnswer(QuestionFixture.MULTI_CHOICE_QUESTION, Collections.emptyList()));
    }

    @Test
    void answerWithCorrectChoice_shouldBeCorrect() {
        assertThat(AnswerFixture.CORRECT_MULTI_CHOICE_ANSWER.isCorrect()).isTrue();
    }

    @Test
    void answerWithIncorrectChoice_shouldBeIncorrect() {
        assertThat(AnswerFixture.INCORRECT_MULTI_CHOICE_ANSWER.isCorrect()).isFalse();
    }

    @Test
    void answerWithPartiallyCorrectChoice_shouldBeIncorrect() {
        assertThat(AnswerFixture.PARTIALLY_CORRECT_MULTI_CHOICE_ANSWER.isCorrect()).isFalse();
    }
}