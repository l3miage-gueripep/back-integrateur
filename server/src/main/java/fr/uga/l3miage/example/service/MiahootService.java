package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.exception.rest.*;
import fr.uga.l3miage.example.exception.technical.*;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MiahootService {

    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité TestConfigWithProperties à été détecté.";
    private final MiahootComponent miahootComponent;
    private final MiahootMapper miahootMapper;

    public void createMiahoot(final CreateMiahootRequest createMiahootRequest) {
        Miahoot newMiahootEntity = miahootMapper.toEntity(createMiahootRequest);
        miahootComponent.create(newMiahootEntity);
    }

    public List<MiahootDTO> findAll(){
        return miahootComponent.findAll().stream().map(miahootMapper::toDto).collect(Collectors.toList());
    }

    public MiahootDTO findById(Long id){
        try{
            return miahootMapper.toDto(miahootComponent.findById(id));
        } catch (NotFoundException ex) {
            throw new NotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]", ex.getMessage()), id, ex);
        }
    }


}
