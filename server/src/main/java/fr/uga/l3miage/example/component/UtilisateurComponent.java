package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.error.MiahootNotFoundErrorResponse;

import fr.uga.l3miage.example.exception.rest.NotFoundRestException;

import fr.uga.l3miage.example.exception.technical.*;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.mapper.UtilisateurMapper;
import fr.uga.l3miage.example.models.*;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.repository.ReponseRepository;
import fr.uga.l3miage.example.repository.UtilisateurRepository;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.Test;
import fr.uga.l3miage.example.response.UtilisateurDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UtilisateurComponent {
    private final UtilisateurRepository utilisateurRepository;
    private final ReponseComponent reponseComponent;
    private final MiahootComponent miahootComponent;
    private final UtilisateurMapper utilisateurMapper;
    private final ReponseRepository reponseRepository;

    public void create(final Utilisateur utilisateur) throws FirebaseIdAlreadyExistsException {
        if(utilisateurRepository.findByFirebaseId(utilisateur.getFirebaseId()).isPresent()) {
            throw new FirebaseIdAlreadyExistsException(String.format("L'id firebase %s existe déjà en BD.", utilisateur.getFirebaseId()), utilisateur.getFirebaseId());        }
        utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> findAll(){
        return utilisateurRepository.findAll();
    }

    public Utilisateur findById(Long id) throws NotFoundException {
        return utilisateurRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Aucun utilisateur n'a été trouvé pour l'id [%d]", id), id));
    }

    public Utilisateur findByFirebaseId(String firebaseId) throws NotFoundByStringException {
        return utilisateurRepository.findByFirebaseId(firebaseId).orElseThrow(() -> new NotFoundByStringException(String.format("Aucun utilisateur n'a été trouvé pour l'id firebase [%s]", firebaseId), firebaseId));
    }

    public void deleteById(Long id) {
        try {
            Utilisateur u = findById(id);
        } catch (NotFoundException ex) {
            throw new NotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()), id, ex);
        }
        utilisateurRepository.deleteById(id);
    }

    public void updateUtilisateur(final Long id, final UtilisateurDTO utilisateurDTO) throws  NotFoundException {

        Utilisateur actualUtilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Aucune entité n'a été trouvée pour l'id [%s]",id), id));
        utilisateurMapper.mergeTestEntity(actualUtilisateur, utilisateurDTO);
        utilisateurRepository.save(actualUtilisateur);
    }

    public List<Utilisateur> findAllByReponseId(Long reponseId) throws NotFoundException {
        Reponse reponse = reponseComponent.findById(reponseId);
        return utilisateurRepository.findByReponsesContaining(reponse);
    }

    public List<Utilisateur> findAllByMiahootParticipes(Long miahootId) throws NotFoundException {
        Miahoot miahoot = miahootComponent.findById(miahootId);
        return utilisateurRepository.findByMiahootsParticipes(miahoot);
    }

//    public void submitReponse(Long reponseId, String userFirebaseId) throws NotFoundException{
//        Reponse reponse = reponseRepository.findById(reponseId).orElseThrow(() -> new NotFoundException(String.format("Aucune Repone n'a été trouvée pour l'id [%s]",reponseId), reponseId));
//    }
}
