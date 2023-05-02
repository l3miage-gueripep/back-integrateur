package fr.uga.l3miage.example.endpoint;


import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.QuestionDTO;
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
@RequestMapping
public interface ReponseEndPoint {
    @Operation(description = "Création d'une entité Reponse") //swagger
    @ApiResponse(responseCode = "201", description = "L'entité Reponse a bien été créée.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("question/{questionId}/reponse")
    void createEntityReponse(Long questionId,@Valid @RequestBody final String label);

    @Operation(description = "Affiche tous les reponses existants")
    @ApiResponse(responseCode = "200", description = "Entités reponses trouvées")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("reponse/")
    List<ReponseDTO> getAll();

    @Operation(description = "Obtention des Reponses pour une Question donnée") //swagger
    @ApiResponse(responseCode = "200", description = "La question a bien été trouvé.") //swagger
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("question/{questionId}/reponses")
    List<ReponseDTO> findAllByQuestionId(@PathVariable final Long questionId);

    @Operation(description = "Affiche la question correspondant à l'id donné")
    @ApiResponse(responseCode = "200", description = "Entité réponse trouvée")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("reponse/{reponseId}")
    ReponseDTO findById(@PathVariable Long id);


}
