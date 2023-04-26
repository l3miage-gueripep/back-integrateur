package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.DescriptionAlreadyExistException;
import fr.uga.l3miage.example.exception.technical.IsNotMiahootException;
import fr.uga.l3miage.example.exception.technical.IsNotTestException;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.repository.MiahootRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MiahootComponent {
    private final MiahootRepository miahootRepository;
    private final MiahootMapper miahootMapper;

    public void create(final Miahoot entity){
        miahootRepository.save(entity);
    }
}
