package fr.uga.l3miage.example.endpoint;


import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.ReponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Reponse tag") //swagger
@CrossOrigin
@RestController
@RequestMapping("reponse/")
public interface ReponseEndPoint {
    @Operation(description = "Création d'une entité Reponse") //swagger
    @ApiResponse(responseCode = "201", description = "L'entité Reponse a bien été créée.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createEntityReponse(@Valid @RequestBody final CreateReponseRequest request);

    @Operation(description = "Affiche tous les reponses existants")
    @ApiResponse(responseCode = "200", description = "Entités reponses trouvées")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<ReponseDTO> getAll();
}
