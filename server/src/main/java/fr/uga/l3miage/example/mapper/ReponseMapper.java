package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.ReponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReponseMapper{
    //@Mapping(source = "queston.id", target = "questionId")
    ReponseDTO toDto(Reponse entity);

    @Mapping(target = "estValide", source = "estValide")
    @Mapping(target = "label", source = "label")
    //@Mapping(source = "questionId", target = "question.id")
    Reponse toEntity(CreateReponseRequest request);
}
