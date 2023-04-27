package fr.uga.l3miage.example.endpoint;


import fr.uga.l3miage.example.request.CreateQuestionRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Question tag") //swagger
@CrossOrigin
@RestController
@RequestMapping("question/")
public interface QuestionEndpoint {
    @Operation(description = "Création d'une entité Question") //swagger
    @ApiResponse(responseCode = "201", description = "L'entité Question a bien été créée.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createEntityQuestion(@RequestBody final CreateQuestionRequest request);

}
