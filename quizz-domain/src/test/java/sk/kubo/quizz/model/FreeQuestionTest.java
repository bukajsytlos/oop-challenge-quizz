package sk.kubo.quizz.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class FreeQuestionTest {

    @Test
    void create_validQuestion_shouldBeOk() {
        assertDoesNotThrow(() -> QuestionFixture.FREE_QUESTION);
    }

    @Test
    void create_questionWithoutDescription_shouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new FreeQuestion(null, v -> true));
    }

    @Test
    void create_questionWithEmptyDescription_shouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new FreeQuestion("", v -> true));;
    }

    @Test
    void create_questionWithoutCorrectAnswerPredicate_shouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new FreeQuestion("Question", null));
    }
}