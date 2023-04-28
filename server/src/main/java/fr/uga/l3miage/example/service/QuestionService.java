package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.component.QuestionComponent;
import fr.uga.l3miage.example.exception.rest.MiahootNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.QuestionNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.TestEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.technical.MiahootNotFoundException;
import fr.uga.l3miage.example.exception.technical.QuestionNotFoundException;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.QuestionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {

    private  static  final  String ERROR_DETECTED = "Une erreur lors de la création de l'entité  à été détectée";
    private final QuestionComponent questionComponent;
    private final MiahootComponent miahootComponent;
    private final QuestionMapper questionMapper;

    public void createQuestion(final String label, Long miahootId) {
        Question newQuestionEntity = questionMapper.toEntity(label);
        questionComponent.create(newQuestionEntity);
        bind(miahootId, newQuestionEntity);
    }
    public List<QuestionDTO> findAllByMiahootId(Long miahootId){
        try{
            return questionComponent.findAllByMiahootId(miahootId).stream().map(questionMapper::toDto).collect(Collectors.toList());
        } catch(MiahootNotFoundException ex){
            throw new MiahootNotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()), miahootId, ex);
        }
    }

    public List<QuestionDTO> findAll(){
        return questionComponent.findAll().stream().map(questionMapper::toDto).collect(Collectors.toList());
    }


    public QuestionDTO findById(Long id) {
        try {
            return questionMapper.toDto(questionComponent.findById(id));
        } catch (QuestionNotFoundException ex) {
            throw new QuestionNotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()),id,ex);
        }
    }


    private void bind(Long miahootId, Question question){
        try{
            Miahoot miahoot = miahootComponent.findById(miahootId);
            miahoot.addQuestion(question);
            question.setMiahoot(miahoot);
        } catch(MiahootNotFoundException ex){
            throw new MiahootNotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()), miahootId, ex);
        }
    }

}
