package fr.uga.l3miage.example.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Builder
@Schema(description = "correspond au DTO de l'entité Question")
public class QuestionDTO {

    @Schema(description = "correspond au label de la question",example = "comment on springboot ?")
    @Nullable
    String label;

    

}
