package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.error.MiahootNotFoundErrorResponse;
import fr.uga.l3miage.example.exception.rest.MiahootNotFoundRestException;
import fr.uga.l3miage.example.exception.technical.MiahootNotFoundException;
import fr.uga.l3miage.example.exception.technical.NotFoundException;
import fr.uga.l3miage.example.exception.technical.TestEntityNotFoundException;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.response.MiahootDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public Miahoot findById(Long id) throws NotFoundException {
        return miahootRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Aucun miahoot n'a été trouvé pour l'id [%d]", id), id));
    }

    public void deleteById(Long id) {
        try {
            Miahoot m = findById(id);
        } catch (MiahootNotFoundException ex) {
            throw new MiahootNotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()), id, ex);
        }
        miahootRepository.deleteById(id);
    }

}
