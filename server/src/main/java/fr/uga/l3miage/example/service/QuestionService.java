package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.QuestionComponent;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private  static  final  String ERROR_DETECTED = "Une erreur lors de la création de l'entité  à été détectée";
    private final QuestionComponent questionComponent;
    private final QuestionMapper questionMapper;

    public void createQuestion(final CreateQuestionRequest createQuestionRequest) {
        Question newQuestionEntity = questionMapper.toEntity(createQuestionRequest);
        questionComponent.create(newQuestionEntity);
    }

}
