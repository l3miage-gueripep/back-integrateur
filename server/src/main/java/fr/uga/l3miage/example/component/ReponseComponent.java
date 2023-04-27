package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.mapper.ReponseMapper;
import fr.uga.l3miage.example.models.Reponse;
import fr.uga.l3miage.example.repository.ReponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReponseComponent {
    private final ReponseRepository reponseRepository;
    private final ReponseMapper reponseMapper;

    public void createReponse(final Reponse reponse){
        reponseRepository.save(reponse);
    }

    public List<Reponse> findAll(){
        return reponseRepository.findAll();
    }
}
