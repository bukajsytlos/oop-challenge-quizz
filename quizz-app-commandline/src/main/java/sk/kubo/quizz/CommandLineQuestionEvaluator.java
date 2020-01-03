package sk.kubo.quizz;

import java.util.List;
import java.util.stream.Collectors;

import sk.kubo.quizz.model.Answer;
import sk.kubo.quizz.model.MultiChoiceAnswer;
import sk.kubo.quizz.model.MultiChoiceQuestion;
import sk.kubo.quizz.model.NoAnswer;
import sk.kubo.quizz.model.Question;
import sk.kubo.quizz.model.QuestionChoice;
import sk.kubo.quizz.model.QuestionEvaluator;
import sk.kubo.quizz.model.SingleChoiceAnswer;
import sk.kubo.quizz.model.SingleChoiceQuestion;

public class CommandLineQuestionEvaluator implements QuestionEvaluator {

    private CommandLineInput commandLineInput;

    public CommandLineQuestionEvaluator(CommandLineInput commandLineInput) {
        this.commandLineInput = commandLineInput;
    }

    @Override
    public Answer<?> evaluate(SingleChoiceQuestion question) {
        System.out.println(question.getDescription() + "[single choice]");
        final List<QuestionChoice> questionChoices = question.getQuestionChoices();
        for (int answerIndex = 0; answerIndex < questionChoices.size(); answerIndex++) {
            System.out.println((answerIndex + 1) + ". " + questionChoices.get(answerIndex).getDescription());
        }
        final int chosenChoiceIndex = commandLineInput.readNumericUserInput();
        return new SingleChoiceAnswer(question, questionChoices.get(chosenChoiceIndex - 1));
    }

    @Override
    public Answer<?> evaluate(MultiChoiceQuestion question) {
        System.out.println(question.getDescription() + "[multiple choices]");
        final List<QuestionChoice> questionChoices = question.getQuestionChoices();
        for (int answerIndex = 0; answerIndex < questionChoices.size(); answerIndex++) {
            System.out.println((answerIndex + 1) + ". " + questionChoices.get(answerIndex).getDescription());
        }
        final List<Integer> chosenChoiceIndices = commandLineInput.readMultiNumericUserInput();
        final List<QuestionChoice> chosenChoices = chosenChoiceIndices.stream()
            .map(chosenChoiceIndex -> questionChoices.get(chosenChoiceIndex - 1))
            .collect(Collectors.toList());
        return new MultiChoiceAnswer(question, chosenChoices);
    }

    @Override
    public Answer<?> evaluate(Question question) {
        System.out.println("Question of unknown type [" + question.getClass().getSimpleName() + "]. Skipping question.");
        return new NoAnswer(question);
    }
}
