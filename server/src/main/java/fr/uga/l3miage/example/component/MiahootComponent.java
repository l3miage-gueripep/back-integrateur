package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.error.MiahootNotFoundErrorResponse;
import fr.uga.l3miage.example.exception.technical.MiahootNotFoundException;
import fr.uga.l3miage.example.exception.technical.TestEntityNotFoundException;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.TestEntity;
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

    public Miahoot findById(Long id) throws MiahootNotFoundException {
        return miahootRepository.findById(id).orElseThrow(() -> new MiahootNotFoundException(String.format("Aucun miahoot n'a été trouvé pour l'id [%d]", id), id));
    }

}
