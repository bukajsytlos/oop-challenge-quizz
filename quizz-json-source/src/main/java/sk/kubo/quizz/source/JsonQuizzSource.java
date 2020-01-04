package sk.kubo.quizz.source;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import sk.kubo.quizz.model.Quizz;
import sk.kubo.quizz.source.spi.QuizzSource;

public class JsonQuizzSource implements QuizzSource {
    private InputStream inputStream;
    private ObjectMapper objectMapper;

    public JsonQuizzSource(InputStream inputStream) {
        this.inputStream = inputStream;
        objectMapper = new ObjectMapper();
    }

    @Override
    public List<Quizz> getQuizzes() {
        try {
            List<QuizzDto> quizzDtos = objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, QuizzDto.class));
            return quizzDtos.stream()
                .map(QuizzDto::asQuizz)
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
