package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.component.ReponseComponent;
import fr.uga.l3miage.example.component.UtilisateurComponent;
import fr.uga.l3miage.example.exception.rest.FirebaseIdAlreadyExistsRestException;
import fr.uga.l3miage.example.exception.rest.NotFoundByStringRestException;
import fr.uga.l3miage.example.exception.rest.NotFoundRestException;
import fr.uga.l3miage.example.exception.technical.DescriptionAlreadyExistException;
import fr.uga.l3miage.example.exception.technical.FirebaseIdAlreadyExistsException;
import fr.uga.l3miage.example.exception.technical.NotFoundByStringException;
import fr.uga.l3miage.example.exception.technical.NotFoundException;
import fr.uga.l3miage.example.mapper.UtilisateurMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.models.Utilisateur;
import fr.uga.l3miage.example.request.CreateUtilisateurRequest;
import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.response.UtilisateurDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UtilisateurService {

    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité TestConfigWithProperties à été détecté.";
    private final UtilisateurComponent utilisateurComponent;
    private final ReponseComponent reponseComponent;
    private final MiahootComponent miahootComponent;
    private final UtilisateurMapper utilisateurMapper;

    public void createUtilisateur(final CreateUtilisateurRequest createUtilisateurRequest){
        Utilisateur newUtilisateurEntity = utilisateurMapper.toEntity(createUtilisateurRequest);
        try {
            utilisateurComponent.create(newUtilisateurEntity);
        } catch (FirebaseIdAlreadyExistsException e) {
            throw new FirebaseIdAlreadyExistsRestException(ERROR_DETECTED,newUtilisateurEntity.getFirebaseId(),e);
        }

    }

    public List<UtilisateurDTO> findAll(){
        return utilisateurComponent.findAll().stream().map(utilisateurMapper::toDto).collect(Collectors.toList());
    }

    public UtilisateurDTO findById(Long id){
        try{
            return utilisateurMapper.toDto(utilisateurComponent.findById(id));
        } catch (NotFoundException ex) {
            throw new NotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()), id, ex);
        }
    }

    public void deleteById(Long id) {
        utilisateurComponent.deleteById(id);
    }

    public void update(final Long id, final UtilisateurDTO utilisateurDTO) {
        try {
            utilisateurComponent.updateUtilisateur(id,utilisateurDTO);
        } catch (NotFoundException e) {
            throw new NotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", e.getMessage()), id, e);
        }
    }

    public void submitReponse(Long reponseId, String userFirebaseId) {
        try {
            Utilisateur utilisateur = utilisateurComponent.findByFirebaseId(userFirebaseId);
            bindReponse(reponseId,utilisateur);
        } catch (NotFoundByStringException e){
            throw new NotFoundByStringRestException(String.format("Impossible de charger l'entité. Raison : [%s]", e.getMessage()), userFirebaseId, e);
        }
    }

    public void joinMiahoot(Long miahootId, String userFirebaseId) {
        try {
            Utilisateur utilisateur = utilisateurComponent.findByFirebaseId(userFirebaseId);
            bindMiahoot(miahootId,utilisateur);
        } catch (NotFoundByStringException e) {
            throw new NotFoundByStringRestException(String.format("Impossible de charger l'entité. Raison : [%s]", e.getMessage()), userFirebaseId, e);
        }
    }

    public List<UtilisateurDTO> findAllByReponseId(Long reponseId){
        try{
            return utilisateurComponent.findAllByReponseId(reponseId).stream().map(utilisateurMapper::toDto).collect(Collectors.toList());
        } catch(NotFoundException ex){
            throw new NotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()), reponseId, ex);
        }
    }

    public List<UtilisateurDTO> findAllByMiahootParticipte(Long miahootId) {

        try {
            return utilisateurComponent.findAllByMiahootParticipes(miahootId).stream().map(utilisateurMapper::toDto).collect(Collectors.toList());
        } catch (NotFoundException e) {
            throw new NotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", e.getMessage()), miahootId, e);
        }

    }

    //executé lorsqu'un utilisateur choisit une reponse comme etant la bonne
    private void bindReponse(Long reponseId, Utilisateur utilisateur){
        try{
            Reponse reponse = reponseComponent.findById(reponseId);
            reponse.addUtilisateur(utilisateur);
            utilisateur.addReponse(reponse);
        } catch(NotFoundException ex){
            throw new NotFoundRestException(String.format("Impossible de charger la réponse. Raison : [%s]", ex.getMessage()), reponseId, ex);
        }
    }

    private void bindMiahoot(Long miahootId, Utilisateur utilisateur) {
        try {

            List participants = new ArrayList<Utilisateur>();
            participants.add(utilisateur);
            List miahootsParticipes = new ArrayList<Miahoot>();

            Miahoot miahoot = miahootComponent.findById(miahootId);
            miahootsParticipes.add(miahoot);
            utilisateur.setMiahootsParticipes(miahootsParticipes);
            miahoot.setParticipants(participants);
        } catch (NotFoundException e) {
            throw new NotFoundRestException(String.format("Impossible de charger la réponse. Raison : [%s]", e.getMessage()), miahootId, e);
        }
    }
}
