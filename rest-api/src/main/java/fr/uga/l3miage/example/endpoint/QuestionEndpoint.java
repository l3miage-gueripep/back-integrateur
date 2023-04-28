package fr.uga.l3miage.example.endpoint;


import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.QuestionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Question tag") //swagger
@CrossOrigin
@RestController
@RequestMapping
public interface QuestionEndpoint {
    @Operation(description = "Création d'une entité Question") //swagger
    @ApiResponse(responseCode = "201", description = "L'entité Question a bien été créée.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("miahoot/{miahootId}/question")
    void createEntityQuestion(@PathVariable Long miahootId ,@RequestParam final String label);


    @Operation(description = "Affiche toutes les questions existantes")
    @ApiResponse(responseCode = "200", description = "Entités questions trouvés")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("question/")
    List<QuestionDTO> getAll();


    @Operation(description = "Obtention des Questions pour un Miahoot donné") //swagger
    @ApiResponse(responseCode = "200", description = "Le miahoot a bien été trouvé.") //swagger
    @ResponseStatus(HttpStatus.OK)
<<<<<<< HEAD
    @GetMapping("miahoot/{miahootId}/questions")
=======
    @GetMapping("{miahootId}/question")
>>>>>>> cc70784489f0cb6f5fb4ca76230195d1177f7a21
    List<QuestionDTO> findAllByMiahootId(@PathVariable final Long miahootId);


    @Operation(description = "Affiche la question correspondant à l'id donné")
    @ApiResponse(responseCode = "200", description = "Entité question trouvée")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{questionId}")
    QuestionDTO findById(@PathVariable Long id);

}
