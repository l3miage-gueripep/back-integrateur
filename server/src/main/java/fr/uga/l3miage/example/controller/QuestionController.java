package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.QuestionEndpoint;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QuestionController implements QuestionEndpoint {
    private final QuestionService questionService;

    @Override
    public void createEntityQuestion(final CreateQuestionRequest request) {
        questionService.createQuestion(request);
    }

    @Override
    public List<QuestionDTO> findAllByMiahootId(Long miahootId) {
        return questionService.findAllByMiahootId(miahootId);
    }
}
