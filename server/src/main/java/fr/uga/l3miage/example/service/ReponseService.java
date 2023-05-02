package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.QuestionComponent;
import fr.uga.l3miage.example.component.ReponseComponent;
import fr.uga.l3miage.example.exception.rest.NotFoundRestException;
import fr.uga.l3miage.example.exception.technical.NotFoundException;
import fr.uga.l3miage.example.mapper.ReponseMapper;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Reponse;
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
    private final QuestionComponent questionComponent;
    private final ReponseMapper reponseMapper;

    public void createReponse(final String label, Long questionId) {
        Reponse newReponseEntity = reponseMapper.toEntity(label);
        reponseComponent.create(newReponseEntity);
        bind(questionId, newReponseEntity);
    }

    public List<ReponseDTO> findAll(){
        return reponseComponent.findAll().stream().map(reponseMapper::toDto).collect(Collectors.toList());
    }

    public List<ReponseDTO> findAllByQuestionId(Long questionId){
        try{
            return reponseComponent.findAllByQuestionId(questionId).stream().map(reponseMapper::toDto).collect(Collectors.toList());
        } catch(NotFoundException ex){
            throw new NotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()), questionId, ex);
        }
    }


    public ReponseDTO findById(Long id) {
        try {
            return reponseMapper.toDto(reponseComponent.findById(id));
        } catch (NotFoundException ex) {
            throw new NotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()),id,ex);
        }
    }

    private void bind(Long questionId, Reponse reponse){
        try{
            Question question = questionComponent.findById(questionId);
            question.addReponse(reponse);
            reponse.setQuestion(question);
        } catch(NotFoundException ex){
            throw new NotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()), questionId, ex);
        }
    }



}
