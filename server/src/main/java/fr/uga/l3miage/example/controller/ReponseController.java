package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.ReponseEndPoint;
import fr.uga.l3miage.example.exception.technical.nbRepException;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.response.ReponseDTO;
import fr.uga.l3miage.example.service.QuestionService;
import fr.uga.l3miage.example.service.ReponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    public void deleteReponse(Long id) {
        reponseService.deleteById(id);
    }

    public List<ReponseDTO> findAllByQuestionId(Long questionId) {
        return reponseService.findAllByQuestionId(questionId);
    }

    @Override
    public ReponseDTO findById(Long reponseId) {
        return reponseService.findById(reponseId);
    }

    @Override
    public void updateReponse(Long id, ReponseDTO reponseDTO) {
        reponseService.update(id,reponseDTO);
    }

}
