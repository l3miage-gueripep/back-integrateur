package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.ReponseComponent;
import fr.uga.l3miage.example.component.UtilisateurComponent;
import fr.uga.l3miage.example.exception.rest.NotFoundByStringRestException;
import fr.uga.l3miage.example.exception.rest.NotFoundRestException;
import fr.uga.l3miage.example.exception.technical.NotFoundByStringException;
import fr.uga.l3miage.example.exception.technical.NotFoundException;
import fr.uga.l3miage.example.mapper.UtilisateurMapper;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.models.Utilisateur;
import fr.uga.l3miage.example.request.CreateUtilisateurRequest;
import fr.uga.l3miage.example.response.UtilisateurDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UtilisateurService {

    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité TestConfigWithProperties à été détecté.";
    private final UtilisateurComponent utilisateurComponent;
    private final ReponseComponent reponseComponent;
    private final UtilisateurMapper utilisateurMapper;

    public void createUtilisateur(final CreateUtilisateurRequest createUtilisateurRequest) {
        Utilisateur newUtilisateurEntity = utilisateurMapper.toEntity(createUtilisateurRequest);
        utilisateurComponent.create(newUtilisateurEntity);
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
            bind(reponseId,utilisateur);
        } catch (NotFoundByStringException e){
            throw new NotFoundByStringRestException(String.format("Impossible de charger l'entité. Raison : [%s]", e.getMessage()), userFirebaseId, e);
        }
    }

    //executé lorsqu'un utilisateur choisit une reponse comme etant la bonne
    private void bind(Long reponseId, Utilisateur utilisateur){
        try{
            Reponse reponse = reponseComponent.findById(reponseId);
            reponse.addUtilisateur(utilisateur);
            utilisateur.addReponse(reponse);
        } catch(NotFoundException ex){
            throw new NotFoundRestException(String.format("Impossible de charger la réponse. Raison : [%s]", ex.getMessage()), reponseId, ex);
        }
    }
}
