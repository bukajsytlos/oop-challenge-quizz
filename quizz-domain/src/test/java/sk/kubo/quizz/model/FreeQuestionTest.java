package sk.kubo.quizz.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class FreeQuestionTest {

    @Test
    void create_validQuestion_shouldBeOk() {
        assertThatCode(() -> new FreeQuestion("Question", v -> true)).doesNotThrowAnyException();
    }

    @Test
    void create_questionWithoutDescription_shouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new FreeQuestion(null, v -> true));
    }

    @Test
    void create_questionWithEmptyDescription_shouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new FreeQuestion("", v -> true));
    }

    @Test
    void create_questionWithoutCorrectAnswerPredicate_shouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new FreeQuestion("Question", null));
    }
}