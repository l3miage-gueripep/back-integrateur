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
@RequestMapping
public interface UtilisateurEndpoint {

    @Operation(description = "Création d'une entité Utilisateur") //swagger
    @ApiResponse(responseCode = "201", description = "L'entité Utilisateur a bien été créée.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("utilisateur/")
    void createEntityUtilisateur(@Valid @RequestBody final CreateUtilisateurRequest request);

    @Operation(description = "Affiche tous les Utilisateurs existants")
    @ApiResponse(responseCode = "200", description = "Entités utilisateurs trouvées")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("utilisateur/")
    List<UtilisateurDTO> getAll();

    @Operation(description = "Affiche l'Utilisateur correspondant à l'id donné")
    @ApiResponse(responseCode = "200", description = "Entité utilisateur trouvée")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("utilisateur/{id}")
    UtilisateurDTO findById(@PathVariable Long id);

    @Operation(description = "Suppression d'une entité Utilisateur en bd")
    @ApiResponse(responseCode = "200", description = "L'Utilisateur a bien été supprimé")
    @ApiResponse(responseCode = "418", description = "Renvoie une erreur 418 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = TestEntityNotDeletedErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("utilisateur/{id}")
    void deleteUtilisateur(@PathVariable Long id);

    @Operation(description = "Mise à jour d'une entité utilisateur")
    @ApiResponse(responseCode = "202", description = "L'entité à bien été mis à jour")
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'est pas trouvée",
            content = @Content(schema = @Schema(implementation = NotFoundErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PatchMapping("utilisateur/{id}")
    void updateUtilisateur(@PathVariable final Long id,@RequestBody final UtilisateurDTO utilisateurDTO);

    @Operation(description = "Vote pour une reponse") //swagger
    @ApiResponse(responseCode = "201", description = "Le choix de reponse a bien ete envoye.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("reponse/{reponseId}/user/{userFirebaseId}")
    void submitReponse(@PathVariable Long reponseId, @Valid @RequestParam final String userFirebaseId);

    @Operation(description = "Rejoins un miahoot en tant que participant") //swagger
    @ApiResponse(responseCode = "200", description = "Le miahoot a bien été rejoint") // swagger
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("miahoot/{miahootId}/participant/{userFirebaseId}")
    void joinMiahootParticipant(@PathVariable Long miahootId, @Valid @RequestParam final String userFirebaseId);

    @Operation(description = "Rejoins un miahoot en tant que presentateur") //swagger
    @ApiResponse(responseCode = "200", description = "Le miahoot a bien été rejoint") // swagger
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("miahoot/{miahootId}/presentateur/{userFirebaseId}")
    void joinMiahootPresentateur(@PathVariable Long miahootId, @Valid @RequestParam final String userFirebaseId);

    @Operation(description = "Rejoins un miahoot en tant que concepteur") //swagger
    @ApiResponse(responseCode = "200", description = "Le miahoot a bien été rejoint") // swagger
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("miahoot/{miahootId}/concepteur/{userFirebaseId}")
    void joinMiahootConcepteur(@PathVariable Long miahootId, @Valid @RequestParam final String userFirebaseId);

    @Operation(description = "Affiche les utilisateurs correspondant à la réponse donnée")
    @ApiResponse(responseCode = "200", description = "Entités utilisateurs trouvées")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("reponse/{reponseId}/users")
    List<UtilisateurDTO> findAllByReponseId(@PathVariable Long reponseId);


    @Operation(description = "Affiche les utilisateurs qui ont participé au miahoot donné") //swagger
    @ApiResponse(responseCode = "200", description = "Entité utilisateurs trouvés")//swagger
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("miahoot/{miahootId}/users")
    List<UtilisateurDTO> findAllByMiahootParticipes(@PathVariable Long miahootId);

    @Operation(description = "Affiche les participants correspondant au miahoot donné")
    @ApiResponse(responseCode = "200", description = "Miahoot trouvé")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("miahoot/{miahootId}/participants")
    List<UtilisateurDTO> findParticipantsByMiahoot(@PathVariable Long miahootId);

    @Operation(description = "Affiche les presentateurs correspondant au miahoot donné")
    @ApiResponse(responseCode = "200", description = "Miahoot trouvé")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("miahoot/{miahootId}/presentateurs")
    List<UtilisateurDTO> findPresentateursByMiahoot(@PathVariable Long miahootId);


    @Operation(description = "Affiche les concepteurs correspondant au miahoot donné")
    @ApiResponse(responseCode = "200", description = "Miahoot trouvé")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("miahoot/{miahootId}/concepteurs")
    List<UtilisateurDTO> findConcepteursByMiahoot(@PathVariable Long miahootId);
}
