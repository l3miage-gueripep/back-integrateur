package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.UtilisateurEndpoint;
import fr.uga.l3miage.example.request.CreateUtilisateurRequest;
import fr.uga.l3miage.example.response.UtilisateurDTO;
import fr.uga.l3miage.example.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UtilisateurController implements UtilisateurEndpoint {
    private final UtilisateurService utilisateurService;

    @Override
    public void createEntityUtilisateur(@Valid @RequestBody final CreateUtilisateurRequest request) {
        utilisateurService.createUtilisateur(request);
    }

    @Override
    public List<UtilisateurDTO> getAll() {
        return utilisateurService.findAll();
    }

    @Override
    public UtilisateurDTO findById(Long id) {
        return utilisateurService.findById(id);
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurService.deleteById(id);
    }

    @Override
    public void updateUtilisateur(Long id, UtilisateurDTO utilisateurDTO) { utilisateurService.update(id,utilisateurDTO);
    }

    @Override
    public void submitReponse(Long reponseId, String userFirebaseId) { utilisateurService.submitReponse(reponseId,userFirebaseId);

    }


}


