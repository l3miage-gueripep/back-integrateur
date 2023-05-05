package fr.uga.l3miage.example.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Schema(description = "correspond au DTO de l'entité Partie")
public class PartieDTO {

    Long id;

    private Date date;

    Long miahootId;

    Boolean isActive;


//    List<SessionDTO> sessions;
}
