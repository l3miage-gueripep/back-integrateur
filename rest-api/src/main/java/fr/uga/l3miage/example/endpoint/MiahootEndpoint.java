package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.annotations.Error400Custom;
import fr.uga.l3miage.example.error.TestEntityNotDeletedErrorResponse;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
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

@Tag(name = "Miahoot tag") //swagger
@CrossOrigin
@RestController
@RequestMapping("miahoot/")
public interface MiahootEndpoint {
    @Operation(description = "Création d'une entité Miahoot") //swagger
    @ApiResponse(responseCode = "201", description = "L'entité Miahoot a bien été créée.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createEntityMiahoot(@Valid @RequestBody final CreateMiahootRequest request);

    @Operation(description = "Affiche tous les Miahoots existants")
    @ApiResponse(responseCode = "200", description = "Entités miahoots trouvées")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<MiahootDTO> getAll();

    @Operation(description = "Affiche le Miahoot correspondant à l'id donné")
    @ApiResponse(responseCode = "200", description = "Entité miahoot trouvée")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    MiahootDTO findById(@PathVariable Long id);

    @Operation(description = "Suppression d'une entité Miahoot en bd")
    @ApiResponse(responseCode = "200", description = "Le miahoot a bien été supprimé")
    @ApiResponse(responseCode = "418", description = "Renvoie une erreur 418 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = TestEntityNotDeletedErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    void deleteMiahoot(@PathVariable Long id);
}
