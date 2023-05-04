package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.error.NotFoundErrorResponse;
import fr.uga.l3miage.example.error.TestEntityNotDeletedErrorResponse;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.PartieDTO;
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

@Tag(name = "Partie tag") //swagger
@CrossOrigin
@RestController
public interface PartieEndpoint {
    @Operation(description = "Création d'une entité Partie") //swagger
    @ApiResponse(responseCode = "201", description = "L'entité Partie a bien été créée.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("miahoot/{miahootId}/partie")
    void createEntityPartie(@PathVariable final Long miahootId);

    @Operation(description = "Visualisation de toutes les entités partie") //swagger
    @ApiResponse(responseCode = "200", description = "Entités bien recherchées.") //swagger
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("partie/")
    List<PartieDTO> getAll();

}
