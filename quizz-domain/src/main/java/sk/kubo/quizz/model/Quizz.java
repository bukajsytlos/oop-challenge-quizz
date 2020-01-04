package sk.kubo.quizz.model;

import static com.toddfast.util.preconditions.Preconditions.argumentIsValue;

import java.util.ArrayList;
import java.util.List;

public class Quizz {
    private String name;
    private List<Question> questions;

    private Quizz(String name, List<Question> questions) {
        this.name = argumentIsValue(name, "name");
        if (questions == null || questions.size() < 3) {
            throw new IllegalArgumentException("Quizz should have at least 3 questions");
        }
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public static class Builder {
        private String name;
        private List<Question> questions = new ArrayList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder addQuestion(Question question) {
            questions.add(question);
            return this;
        }

        public Quizz build() {
            return new Quizz(name, questions);
        }
    }
}
