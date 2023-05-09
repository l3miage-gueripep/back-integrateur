package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.component.QuestionComponent;
import fr.uga.l3miage.example.component.ReponseComponent;
import fr.uga.l3miage.example.component.UtilisateurComponent;
import fr.uga.l3miage.example.exception.rest.NotFoundByStringRestException;
import fr.uga.l3miage.example.exception.rest.NotFoundRestException;
import fr.uga.l3miage.example.exception.technical.NotFoundByStringException;
import fr.uga.l3miage.example.exception.technical.NotFoundException;
import fr.uga.l3miage.example.mapper.ReponseMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.models.Utilisateur;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.ReponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReponseService {

    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité Reponse à été détecté.";
    private final ReponseComponent reponseComponent;
    private final QuestionComponent questionComponent;
    private final MiahootComponent miahootComponent;
    private final UtilisateurComponent utilisateurComponent;
    private final ReponseMapper reponseMapper;

    public void createReponse(final Long questionId, CreateReponseRequest request) {
        Reponse newReponseEntity = reponseMapper.toEntity(request);
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

    public void deleteById(Long id) {
        try {
            reponseComponent.deleteById(id);
        } catch (NotFoundException ex) {
            throw new NotFoundRestException(String.format("Impossible de supprimer l'entité. Raison : [%s]", ex.getMessage()), id, ex);
        }
    }


    public ReponseDTO findById(Long id) {
        try {
            return reponseMapper.toDto(reponseComponent.findById(id));
        } catch (NotFoundException ex) {
            throw new NotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()),id,ex);
        }
    }

    public void update(Long id, ReponseDTO reponseDTO) {
        try {
            reponseComponent.updateReponse(id,reponseDTO);
        } catch (NotFoundException e) {
            throw new NotFoundRestException(String.format("Impossible de modifier l'entité. Raison : [%s]", e.getMessage()), id, e);
        }
    }

/*
    public List<ReponseDTO> getUtilisateurReponsesByMiahoot(Long miahootId, String userFirebaseId) {
        try{
            //getting the user matching userFirebaseId
            Utilisateur utilisateur = utilisateurComponent.findByFirebaseId(userFirebaseId);
            //getting the whole list of available reponses in
            Miahoot miahoot = miahootComponent.findById(miahootId);
            List<Reponse> reponses = new ArrayList<>();
            for(Question question : miahoot.getQuestions()){
                for(Reponse reponse : question.getReponses()){
                    reponses.add(reponse);
                }
            }
            //filtre les reponses pour ne garder que celles contenant l'utilisateur puis transforme les reponses en dto et renvoie le resultat sous forme de liste
            return reponses.stream().filter(reponse -> reponse.getUtilisateurs().contains(utilisateur)).map(reponseMapper::toDto).collect(Collectors.toList());

        } catch(NotFoundByStringException e){
            throw new NotFoundByStringRestException(String.format("Impossible de trouver l'entité. Raison : [%s]", e.getMessage()), userFirebaseId, e);
        }
        catch(NotFoundException e) {
            throw new NotFoundRestException(String.format("Impossible de trouver l'entité. Raison : [%s]", e.getMessage()), miahootId, e);
        }


    }

 */

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
