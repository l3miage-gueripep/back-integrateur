package fr.uga.l3miage.example.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@Schema(description = "Correspond à la requête permettant de créer une entité miahoot")
@Getter
public class CreateMiahootRequest {
    @Schema(description = "nom du Miahoot", example = "Test mathematiques")
    private String nom;
    @Schema(description = "description du Miahoot", example = "Un test pour tous les ages")
    private String description;
}
