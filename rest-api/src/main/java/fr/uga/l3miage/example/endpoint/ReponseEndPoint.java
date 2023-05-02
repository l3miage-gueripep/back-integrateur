package fr.uga.l3miage.example.endpoint;


import fr.uga.l3miage.example.error.TestEntityNotDeletedErrorResponse;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.ReponseDTO;
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

@Tag(name = "Reponse tag") //swagger
@CrossOrigin
@RestController
@RequestMapping
public interface ReponseEndPoint {
    @Operation(description = "Création d'une entité Reponse") //swagger
    @ApiResponse(responseCode = "201", description = "L'entité Reponse a bien été créée.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("question/{questionId}/reponse")
    void createEntityReponse(Long questionId,@Valid @RequestBody final CreateReponseRequest request);

    @Operation(description = "Affiche tous les reponses existants")
    @ApiResponse(responseCode = "200", description = "Entités reponses trouvées")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("reponse/")
    List<ReponseDTO> getAll();

    @Operation(description = "Suppression d'une entité reponse en bd")
    @ApiResponse(responseCode = "200", description = "La réponse a bien été supprimée")
    @ApiResponse(responseCode = "418", description = "Renvoie une erreur 418 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = TestEntityNotDeletedErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("reponse/{id}")
    void deleteReponse(@PathVariable Long id);
}
