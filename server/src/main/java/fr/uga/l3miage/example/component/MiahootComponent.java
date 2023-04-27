package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.repository.MiahootRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MiahootComponent {
    private final MiahootRepository miahootRepository;
    private final MiahootMapper miahootMapper;

    public void create(final Miahoot miahoot){
        miahootRepository.save(miahoot);
    }

    public List<Miahoot> findAll(){
        return miahootRepository.findAll();
    }
}
