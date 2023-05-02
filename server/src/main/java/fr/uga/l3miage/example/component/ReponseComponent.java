package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.NotFoundException;
import fr.uga.l3miage.example.mapper.ReponseMapper;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.repository.ReponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReponseComponent {
    private final ReponseRepository reponseRepository;
    private final QuestionComponent questionComponent;
    private final ReponseMapper reponseMapper;

    public void create(final Reponse reponse){
        reponseRepository.save(reponse);
    }

    public List<Reponse> findAll(){
        return reponseRepository.findAll();
    }

    public List<Reponse> findAllByQuestionId(Long questionId) throws NotFoundException {
        Question question = questionComponent.findById(questionId);
        System.out.println(question.getReponses());
        return reponseRepository.findAllByQuestion(question);
    }

    public Reponse findById(Long id) throws NotFoundException {
        return reponseRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Aucune réponse n'a été trouvée pour l'id [%d]", id), id));
    }

}
