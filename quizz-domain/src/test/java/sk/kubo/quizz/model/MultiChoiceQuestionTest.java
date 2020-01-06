package sk.kubo.quizz.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MultiChoiceQuestionTest {

    @Test
    void create_questionWithoutDescription_shouldThrowException() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createMultiChoiceQuestion(null, null));
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createMultiChoiceQuestion("", null));
    }

    @Test
    void create_questionWithoutChoices_shouldThrowException() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createMultiChoiceQuestion("question", null));
    }

    @Test
    void create_questionWithLessThanTwoChoices_shouldThrowException() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createMultiChoiceQuestion("question",
            List.of(QuestionFixture.FIRST_CORRECT_CHOICE)
        ));
    }

    @Test
    void create_questionWithMoreThanFiveChoices_shouldThrowException() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createMultiChoiceQuestion("question",
            List.of(
                QuestionFixture.FIRST_CORRECT_CHOICE,
                QuestionFixture.SECOND_CORRECT_CHOICE,
                QuestionFixture.INCORRECT_CHOICE,
                new QuestionChoice("dummy1", false),
                new QuestionChoice("dummy2", false),
                new QuestionChoice("dummy3", false)
            )
        ));
    }

    @Test
    void create_questionWithoutCorrectChoice_shouldThrowException() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createMultiChoiceQuestion("question",
            List.of(
                QuestionFixture.INCORRECT_CHOICE,
                new QuestionChoice("incorrect2", false)
            )
        ));
    }

    @Test
    void check_correctAnswer_shouldReturnTrue() {
        assertThat(QuestionFixture.MULTI_CHOICE_QUESTION.evaluate(List.of(QuestionFixture.FIRST_CORRECT_CHOICE, QuestionFixture.SECOND_CORRECT_CHOICE))).isTrue();
    }

    @Test
    void check_incorrectAnswer_shouldReturnFalse() {
        assertThat(QuestionFixture.MULTI_CHOICE_QUESTION.evaluate(List.of(QuestionFixture.INCORRECT_CHOICE))).isFalse();
    }

    @Test
    void check_partiallyCorrectAnswer_shouldReturnFalse() {
        assertThat(QuestionFixture.MULTI_CHOICE_QUESTION.evaluate(List.of(QuestionFixture.FIRST_CORRECT_CHOICE))).isFalse();
    }
}