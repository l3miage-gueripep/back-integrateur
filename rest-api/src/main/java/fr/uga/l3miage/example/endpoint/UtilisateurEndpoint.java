package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.request.CreateReponseRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Utilisateur tag") //swagger
@CrossOrigin
@RestController
@RequestMapping
public interface UtilisateurEndpoint {


    @Operation(description = "Vote pour une reponse") //swagger
    @ApiResponse(responseCode = "201", description = "Le choix de reponse a bien ete envoye.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("reponse/{reponseId}/user/{userFirebaseId}")
    void submitReponse(@PathVariable Long reponseId, @Valid @RequestParam final String userFirebaseId);
}
