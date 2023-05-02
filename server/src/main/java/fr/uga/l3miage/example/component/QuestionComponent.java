package fr.uga.l3miage.example.component;



import fr.uga.l3miage.example.exception.rest.NotFoundRestException;
import fr.uga.l3miage.example.exception.technical.NotFoundException;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.repository.QuestionRepository;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.QuestionDTO;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.hibernate.loader.plan.spi.QuerySpaceUidNotRegisteredException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionComponent {
    private final QuestionRepository questionRepository;
    private final MiahootComponent miahootComponent;
    private final QuestionMapper questionMapper;

    public void create(final Question entity){
        questionRepository.save(entity);
    }

    public List<Question> findAll(){
        List<Question> questions = questionRepository.findAll();
        for(Question question : questions){
            for(Reponse reponse : question.getReponses()){
                System.out.println(reponse.getId());
            }
        }
        return questions;
    }

    public List<Question> findAllByMiahootId(Long miahootId) throws NotFoundException {
        Miahoot miahoot = miahootComponent.findById(miahootId);
        System.out.println(miahoot.getQuestions());
        return questionRepository.findAllByMiahoot(miahoot);
    }

    public Question findById(Long id) throws NotFoundException {
        return questionRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Aucune Question n'a été trouvée pour l'id [%d]", id), id));
    }

    public void deleteById(Long id) throws NotFoundException {
        Question question = findById(id);
        questionRepository.deleteById(id);
    }

    public void updateQuestion(final Long id, final QuestionDTO questionDTO) throws  NotFoundException {
        Question actualQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Aucune entité n'a été trouvée pour l'id [%s]",id), id));
        questionMapper.mergeQuestion(actualQuestion, questionDTO);
        questionRepository.save(actualQuestion);
    }



}
