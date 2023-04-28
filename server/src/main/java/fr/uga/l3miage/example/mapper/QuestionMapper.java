package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.response.ReponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "miahoot.id", target = "miahootId")
    @Mapping(source = "reponses", target = "reponses", qualifiedByName = "mapReponsesToReponseDTOs")
    QuestionDTO toDto(Question entity);

    Question toEntity(String label);

    @Named("mapReponsesToReponseDTOs")
    default List<ReponseDTO> mapReponsesToReponseDTOs(List<Reponse> reponses) {
        return reponses.stream()
                .map(reponse -> ReponseDTO.builder()
                        .id(reponse.getId())
                        .label(reponse.getLabel())
                        .build())
                .collect(Collectors.toList());
    }

}
