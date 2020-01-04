package sk.kubo.quizz;

import java.io.InputStream;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommandLineInput {

    private Scanner scanner;

    public CommandLineInput(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public int readNumericUserInput(int maxValue) {
        System.out.print("Enter choice [e.g. 1]: ");
        try {
            final int number = scanner.nextInt();
            if (number > maxValue) {
                throw new IllegalArgumentException("Chosen value exceed max value [" + maxValue + "]");
            }
            return Math.max(number, 0);
        } catch (Exception e) {
            System.out.println("Wrong input. Choose again.");
            return readNumericUserInput(maxValue);
        }
    }

    public List<Integer> readMultiNumericUserInput(int maxValue) {
        System.out.print("Enter choices [e.g. 1,2,3]: ");
        try {
            final String inputString = scanner.next();
            return Arrays.stream(inputString.split(",", -1))
                .map(Integer::valueOf)
                .map(value -> {
                    if (value > maxValue) {
                        throw new IllegalArgumentException("Chosen value exceed max value [" + maxValue + "]");
                    } else {
                        return value;
                    }
                })
                .map(value -> Math.max(value, 0))
                .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Wrong input. Choose again.");
            return readMultiNumericUserInput(maxValue);
        }
    }
}
