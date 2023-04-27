package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.QuestionDTO;
import org.mapstruct.Mapper;

@Mapper
public interface QuestionMapper {
    QuestionDTO toDto(Question entity);
    Question toEntity(CreateQuestionRequest request);
}
