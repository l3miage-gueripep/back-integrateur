package fr.uga.l3miage.example.endpoint;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Partie tag") //swagger
@CrossOrigin
@RestController
public interface SessionEndpoint {

}