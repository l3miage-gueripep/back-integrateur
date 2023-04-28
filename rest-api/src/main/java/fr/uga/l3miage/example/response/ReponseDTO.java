package fr.uga.l3miage.example.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "correspond au DTO de l'entité Reponse")
public class ReponseDTO {

    @Schema(description = "correspond au label du reponse",example = "vrai")
    String label;

    @Schema(description = "correspond au valeur de validation du reponse",example = "true")
    boolean estValide;

    @Schema(description = "correspond à l'id de la question de la réponse possible", example="1")
    Long questionId;

}
