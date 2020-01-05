package sk.kubo.quizz;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import sk.kubo.quizz.model.Answer;
import sk.kubo.quizz.model.FreeAnswer;
import sk.kubo.quizz.model.FreeQuestion;
import sk.kubo.quizz.model.MultiChoiceAnswer;
import sk.kubo.quizz.model.MultiChoiceQuestion;
import sk.kubo.quizz.model.NoAnswer;
import sk.kubo.quizz.model.Question;
import sk.kubo.quizz.model.QuestionChoice;
import sk.kubo.quizz.model.Quizz;
import sk.kubo.quizz.model.QuizzResult;
import sk.kubo.quizz.model.SingleChoiceAnswer;
import sk.kubo.quizz.model.SingleChoiceQuestion;
import sk.kubo.quizz.source.BuiltinQuizzSource;
import sk.kubo.quizz.source.JsonQuizzSource;
import sk.kubo.quizz.source.spi.QuizzSource;

public class CommandLineApplication {
    private List<Quizz> quizzes;
    private CommandLineInput commandLineInput;

    public CommandLineApplication(QuizzSource quizzSource, CommandLineInput commandLineInput) {
        this.quizzes = quizzSource.getQuizzes();
        this.commandLineInput = commandLineInput;
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            InputStream fileSource = loadJsonFile(args[0]);
            new CommandLineApplication(new JsonQuizzSource(fileSource), new CommandLineInput(System.in)).run();
        } else {
            new CommandLineApplication(new BuiltinQuizzSource(), new CommandLineInput(System.in)).run();
        }
    }

    private static InputStream loadJsonFile(String path) {
        InputStream fileSource = null;
        try {
            final Path quizzSourcePath = Path.of(path);
            if (Files.exists(quizzSourcePath)) {
                fileSource = Files.newInputStream(quizzSourcePath);
            } else {
                System.out.println("Invalid quizz source file path [" + quizzSourcePath.toAbsolutePath().toString() + "]. Using built in one. ");
                fileSource = ClassLoader.getSystemResourceAsStream("MultipleRandomQuizzes.json");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return fileSource;
    }

    public void run() {
        try {
            printWelcomeMessage();
            do {
                evaluateMainMenu();
            } while (true);
        } catch (Exception e) {
            System.err.println("Application failed. Reason: " + e.getMessage());
            System.exit(1);
        }
    }

    private void evaluateMainMenu() {
        System.out.println("1. Take quizz");
        System.out.println("0. Quit");
        chooseMenuItem();
    }

    private void chooseMenuItem() {
        final int chosenMenuItem = commandLineInput.readNumericUserInput(1);
        switch (chosenMenuItem) {
            case 1:
                takeQuizz();
                break;
            case 0:
                System.out.println("Bye bye");
                System.exit(0);
            default:
                chooseMenuItem();
        }
    }

    private void takeQuizz() {
        Optional<Quizz> currentQuizz;
        if (quizzes.size() > 1) {
            currentQuizz = Optional.of(chooseQuizz());
        } else if (quizzes.isEmpty()) {
            currentQuizz = Optional.empty();
        } else {
            currentQuizz = Optional.of(quizzes.get(0));
        }
        currentQuizz.ifPresent(this::evaluateQuizz);
    }

    private Quizz chooseQuizz() {
        System.out.println("Choose quizz:");
        for (int index = 0; index < quizzes.size(); index++) {
            System.out.println((index + 1) + ". " + quizzes.get(index).getName());
        }
        final int chosenQuizzIndex = commandLineInput.readNumericUserInput(quizzes.size());
        return quizzes.get(chosenQuizzIndex - 1);
    }

    private void evaluateQuizz(Quizz quizz) {
        System.out.println("Quizz [" + quizz.getName() + "] has been chosen. Let's start");
        List<Answer<?, ?>> answers = new ArrayList<>();
        for (Question<?> question : quizz.getQuestions()) {
            answers.add(evaluateQuestion(question));
        }
        final QuizzResult quizzResult = new QuizzResult(quizz, answers);
        System.out.println(String.format("You have %d correct answers out of %d", quizzResult.correctAnswersCount(), quizzResult.totalQuestionsCount()));
    }

    private Answer<?, ?> evaluateQuestion(Question<?> question) {
        if (question instanceof FreeQuestion) {
            System.out.println(question.getDescription() + "[free text]");
            final String answer = commandLineInput.readTextUserInput();
            return new FreeAnswer((FreeQuestion) question, answer);
        } else if (question instanceof SingleChoiceQuestion) {
            System.out.println(question.getDescription() + "[single choice]");
            final List<QuestionChoice> questionChoices = ((SingleChoiceQuestion) question).getQuestionChoices();
            for (int answerIndex = 0; answerIndex < questionChoices.size(); answerIndex++) {
                System.out.println((answerIndex + 1) + ". " + questionChoices.get(answerIndex).getDescription());
            }
            final int chosenChoiceIndex = commandLineInput.readNumericUserInput(questionChoices.size());
            return new SingleChoiceAnswer(((SingleChoiceQuestion) question), questionChoices.get(chosenChoiceIndex - 1));
        } else if (question instanceof MultiChoiceQuestion) {
            System.out.println(question.getDescription() + "[multiple choices]");
            final List<QuestionChoice> questionChoices = ((MultiChoiceQuestion) question).getQuestionChoices();
            for (int answerIndex = 0; answerIndex < questionChoices.size(); answerIndex++) {
                System.out.println((answerIndex + 1) + ". " + questionChoices.get(answerIndex).getDescription());
            }
            final List<Integer> chosenChoiceIndices = commandLineInput.readMultiNumericUserInput(questionChoices.size());
            final List<QuestionChoice> chosenChoices = chosenChoiceIndices.stream()
                .map(chosenChoiceIndex -> questionChoices.get(chosenChoiceIndex - 1))
                .collect(Collectors.toList());
            return new MultiChoiceAnswer(((MultiChoiceQuestion) question), chosenChoices);
        } else {
            System.out.println("Question of unknown type [" + question.getClass().getSimpleName() + "]. Skipping question.");
            return new NoAnswer(question);
        }
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to the Quizz app");
    }

}
