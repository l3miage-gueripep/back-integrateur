package fr.uga.l3miage.example.component;


import fr.uga.l3miage.example.exception.rest.QuestionNotFoundRestException;
import fr.uga.l3miage.example.exception.technical.MiahootNotFoundException;
<<<<<<< HEAD
import fr.uga.l3miage.example.exception.technical.NotFoundException;
=======
import fr.uga.l3miage.example.exception.technical.QuestionNotFoundException;
>>>>>>> cc70784489f0cb6f5fb4ca76230195d1177f7a21
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

    public List<Question> findAll(){
        return questionRepository.findAll();
    }

    public List<Question> findAllByMiahootId(Long miahootId) throws MiahootNotFoundException {
        Miahoot miahoot = miahootComponent.findById(miahootId);
        System.out.println(miahoot.getQuestions());
        return questionRepository.findAllByMiahoot(miahoot);
    }

    public Question findById(Long id) throws NotFoundException {
        return questionRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Aucune Question n'a été trouvée pour l'id [%d]", id), id));
    }


}
