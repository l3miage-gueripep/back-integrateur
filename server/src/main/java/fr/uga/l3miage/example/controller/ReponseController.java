package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.ReponseEndPoint;
import fr.uga.l3miage.example.response.ReponseDTO;
import fr.uga.l3miage.example.service.ReponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReponseController implements ReponseEndPoint {
    private final ReponseService reponseService;

    @Override
    public void createEntityReponse(final Long questionId, final String label) {
        reponseService.createReponse(label, questionId);
    }

    @Override
    public List<ReponseDTO> getAll() {
        return reponseService.findAll();
    }

    @Override
    public List<ReponseDTO> findAllByQuestionId(Long questionId) {
        return reponseService.findAllByQuestionId(questionId);
    }

    @Override
    public ReponseDTO findById(Long reponseId) {
        return reponseService.findById(reponseId);
    }

}
