package sk.kubo.quizz.source;

import java.nio.file.Path;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import sk.kubo.quizz.model.Quizz;
import sk.kubo.quizz.source.spi.QuizzSource;

public class JsonFileQuizzSource implements QuizzSource {
    private Path filePath;
    private ObjectMapper objectMapper;

    public JsonFileQuizzSource(Path filePath) {
        this.filePath = filePath;
        objectMapper = new ObjectMapper();
    }

    @Override
    public List<Quizz> getQuizzes() {
        return null;
    }
}
