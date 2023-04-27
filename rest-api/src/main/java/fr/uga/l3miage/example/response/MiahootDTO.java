package fr.uga.l3miage.example.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Builder
@Schema(description = "correspond au DTO de l'entité Miahoot")
public class MiahootDTO {
    @Schema(description = "correspond au nom du miahoot",example = "quizz jpa")
    @Nullable
    String nom;

    @Schema(description = "correspond à la description du miahoot",example = "un des meilleurs quizz de la plateforme")
    String description;

}
