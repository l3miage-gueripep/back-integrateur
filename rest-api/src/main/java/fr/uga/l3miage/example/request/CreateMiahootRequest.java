package fr.uga.l3miage.example.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Correspond à la requête permettant de créer une entité miahoot")
public class CreateMiahootRequest {
    @Schema(description = "nom du miahoot", example = "questionnaire mathematiques")
    String nom;
}
