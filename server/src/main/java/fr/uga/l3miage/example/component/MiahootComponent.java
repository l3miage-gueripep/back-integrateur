package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.repository.MiahootRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MiahootComponent {
    private final MiahootRepository miahootRepository;
    private final MiahootMapper miahootMapper;
}
