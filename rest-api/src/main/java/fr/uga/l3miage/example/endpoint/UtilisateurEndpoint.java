package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.error.NotFoundErrorResponse;
import fr.uga.l3miage.example.error.TestEntityNotDeletedErrorResponse;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.request.CreateUtilisateurRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.UtilisateurDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Utilisateur tag") //swagger
@CrossOrigin
@RestController
@RequestMapping("utilisateur/")
public interface UtilisateurEndpoint {

    @Operation(description = "Création d'une entité Utilisateur") //swagger
    @ApiResponse(responseCode = "201", description = "L'entité Utilisateur a bien été créée.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createEntityUtilisateur(@Valid @RequestBody final CreateUtilisateurRequest request);

    @Operation(description = "Affiche tous les Utilisateurs existants")
    @ApiResponse(responseCode = "200", description = "Entités utilisateurs trouvées")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<UtilisateurDTO> getAll();

    @Operation(description = "Affiche l'Utilisateur correspondant à l'id donné")
    @ApiResponse(responseCode = "200", description = "Entité utilisateur trouvée")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    UtilisateurDTO findById(@PathVariable Long id);

    @Operation(description = "Suppression d'une entité Utilisateur en bd")
    @ApiResponse(responseCode = "200", description = "L'Utilisateur a bien été supprimé")
    @ApiResponse(responseCode = "418", description = "Renvoie une erreur 418 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = TestEntityNotDeletedErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    void deleteUtilisateur(@PathVariable Long id);

    @Operation(description = "Mise à jour d'une entité utilisateur")
    @ApiResponse(responseCode = "202", description = "L'entité à bien été mis à jour")
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'est pas trouvée",
            content = @Content(schema = @Schema(implementation = NotFoundErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PatchMapping("{id}")
    void updateUtilisateur(@PathVariable final Long id,@RequestBody final UtilisateurDTO utilisateurDTO);

    @Operation(description = "Vote pour une reponse") //swagger
    @ApiResponse(responseCode = "201", description = "Le choix de reponse a bien ete envoye.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("reponse/{reponseId}/user/{userFirebaseId}")
    void submitReponse(@PathVariable Long reponseId, @Valid @RequestParam final String userFirebaseId);
}
