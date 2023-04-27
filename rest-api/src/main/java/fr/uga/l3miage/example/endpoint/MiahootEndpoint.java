package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.annotations.Error400Custom;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
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
}
