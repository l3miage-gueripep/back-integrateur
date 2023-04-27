package fr.uga.l3miage.example.component;


import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionComponent {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public void create(final Question entity){
        questionRepository.save(entity);
    }
}
