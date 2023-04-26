package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.annotations.Error400Custom;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Miahoot tag") //swagger
@CrossOrigin
@RestController
@RequestMapping("miahoot/")
public interface MiahootEndpoint {
    //@Operation(description = "Création d'une entité Miahoot") //swagger
    //@ApiResponse(responseCode = "201", description = "L'entité Miahoot a bien été créée.") //swagger
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("test")
    void createEntityMiahoot(@RequestBody final String description);
}
