package sk.kubo.quizz.source;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import sk.kubo.quizz.model.Question;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = SingleChoiceQuestionDto.class, name = "singleChoice"),
    @JsonSubTypes.Type(value = MultiChoiceQuestionDto.class, name = "multiChoice")
})
public abstract class QuestionDto {
    public String description;
    public List<QuestionChoiceDto> questionChoices;

    public abstract Question<?> asQuestion();
}
