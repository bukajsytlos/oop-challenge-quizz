package sk.kubo.quizz.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SingleChoiceQuestionTest {

    @Test
    void create_questionWithoutDescription_shouldThrowException() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createSingleChoiceQuestion(null, null));
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createSingleChoiceQuestion("", null));
    }

    @Test
    void create_questionWithoutChoices_shouldThrowException() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createSingleChoiceQuestion("question", null));
    }

    @Test
    void create_questionWithLessThanTwoChoices_shouldThrowException() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createSingleChoiceQuestion("question",
            List.of(QuestionFixture.FIRST_CORRECT_CHOICE)
        ));
    }

    @Test
    void create_questionWithMoreThanFiveChoices_shouldThrowException() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createSingleChoiceQuestion("question",
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
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createSingleChoiceQuestion("question",
            List.of(
                QuestionFixture.INCORRECT_CHOICE,
                new QuestionChoice("incorrect2", false)
            )
        ));
    }

    @Test
    void create_questionWitMoreThanOneCorrectChoice_shouldThrowException() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> QuestionFactory.createSingleChoiceQuestion("question",
            List.of(
                QuestionFixture.FIRST_CORRECT_CHOICE,
                QuestionFixture.SECOND_CORRECT_CHOICE
            )
        ));
    }

    @Test
    void check_correctAnswer_shouldReturnTrue() {
        assertThat(QuestionFixture.SINGLE_CHOICE_QUESTION.evaluate(QuestionFixture.FIRST_CORRECT_CHOICE)).isTrue();
    }

    @Test
    void check_incorrectAnswer_shouldReturnFalse() {
        assertThat(QuestionFixture.SINGLE_CHOICE_QUESTION.evaluate(QuestionFixture.INCORRECT_CHOICE)).isFalse();
    }
}