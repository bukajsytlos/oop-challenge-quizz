package sk.kubo.quizz;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import sk.kubo.quizz.model.Answer;
import sk.kubo.quizz.model.Question;
import sk.kubo.quizz.model.Quizz;
import sk.kubo.quizz.model.QuizzResult;
import sk.kubo.quizz.source.JsonQuizzSource;
import sk.kubo.quizz.source.spi.QuizzSource;

public class CommandLineApplication {
    private List<Quizz> quizzes;
    private CommandLineInput commandLineInput;
    private CommandLineQuestionEvaluator questionEvaluator;

    public CommandLineApplication(QuizzSource quizzSource, CommandLineInput commandLineInput) {
        this.quizzes = quizzSource.getQuizzes();
        this.commandLineInput = commandLineInput;
        this.questionEvaluator = new CommandLineQuestionEvaluator(commandLineInput);
    }

    public static void main(String[] args) {
        new CommandLineApplication(new JsonQuizzSource(ClassLoader.getSystemResourceAsStream("RandomQuizz1.json")), new CommandLineInput(System.in)).run();
//        new CommandLineApplication(new HardcodedQuizzSource(), new CommandLineInput(System.in)).run();
    }

    public void run() {
        try {
            printWelcomeMessage();
            do {
                evaluateMainMenu();
            } while (true);
        } catch (Exception e) {
            System.err.println("Application failed. Reason: " + e.getMessage());
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
        List<Answer<?>> answers = new ArrayList<>();
        for (Question question : quizz.getQuestions()) {
            answers.add(question.acceptQuestionVisitor(questionEvaluator));
        }
        final QuizzResult quizzResult = new QuizzResult(quizz, answers);
        System.out.println(String.format("You have %d correct answers out of %d", quizzResult.correctAnswersCount(), quizzResult.totalQuestionsCount()));
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to the Quizz app");
    }

}
