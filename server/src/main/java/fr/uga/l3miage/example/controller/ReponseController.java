package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.ReponseEndPoint;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.ReponseDTO;
import fr.uga.l3miage.example.service.ReponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReponseController implements ReponseEndPoint {
    private final ReponseService reponseService;

    @Override
    public void createEntityReponse(final Long questionId, final CreateReponseRequest request) {
        reponseService.createReponse(questionId, request);
    }

    @Override
    public List<ReponseDTO> getAll() {
        return reponseService.findAll();
    }
}
