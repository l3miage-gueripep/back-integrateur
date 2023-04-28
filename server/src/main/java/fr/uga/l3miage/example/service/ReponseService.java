package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.ReponseComponent;
import fr.uga.l3miage.example.mapper.ReponseMapper;
import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.ReponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReponseService {

    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité Reponse à été détecté.";
    private final ReponseComponent reponseComponent;
    private final ReponseMapper reponseMapper;

    public void createReponse(final CreateReponseRequest createReponseRequest) {
        Reponse newReponseEntity = reponseMapper.toEntity(createReponseRequest);
        reponseComponent.createReponse(newReponseEntity);
    }

    public List<ReponseDTO> findAll(){
        return reponseComponent.findAll().stream().map(reponseMapper::toDto).collect(Collectors.toList());
    }

}
