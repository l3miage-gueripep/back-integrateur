package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.ReponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReponseMapper{

    @Mapping(source = "question.id", target = "questionId")
    ReponseDTO toDto(Reponse entity);

    Reponse toEntity(String label);

}
