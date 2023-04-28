package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.QuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "miahoot.id", target = "miahootId")
    QuestionDTO toDto(Question entity);
    @Mapping(source = "miahootId", target = "miahoot.id")
    Question toEntity(CreateQuestionRequest request);
}
