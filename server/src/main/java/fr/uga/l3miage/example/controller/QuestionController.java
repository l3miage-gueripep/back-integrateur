package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.QuestionEndpoint;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionController implements QuestionEndpoint {
    private final QuestionService questionService;

    @Override
    public void createEntityQuestion(final Long miahootId, final String label) {
        questionService.createQuestion(label, miahootId);
    }


    @Override
    public List<QuestionDTO> getAll() {
        return questionService.findAll();
    }

    @Override
    public List<QuestionDTO> findAllByMiahootId(Long miahootId) {
        return questionService.findAllByMiahootId(miahootId);
    }
}
