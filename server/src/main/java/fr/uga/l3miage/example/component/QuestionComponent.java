package fr.uga.l3miage.example.component;


import fr.uga.l3miage.example.exception.rest.QuestionNotFoundRestException;
import fr.uga.l3miage.example.exception.technical.MiahootNotFoundException;
import fr.uga.l3miage.example.exception.technical.QuestionNotFoundException;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
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


    public Question findById(Long id) throws QuestionNotFoundException {
        return questionRepository.findById(id).orElseThrow(() -> new QuestionNotFoundException(String.format("Aucune question n'a été trouvé pour l'id [%d]", id), id));
    }

    public List<Question> findAll(){
        return questionRepository.findAll();
    }

    public List<Question> findAllByMiahootId(Long miahootId) throws MiahootNotFoundException {
        Miahoot miahoot = miahootComponent.findById(miahootId);
        System.out.println(miahoot.getQuestions());
        return questionRepository.findAllByMiahoot(miahoot);
    }


}
