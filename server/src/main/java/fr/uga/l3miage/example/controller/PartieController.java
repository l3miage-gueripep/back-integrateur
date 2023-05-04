package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.PartieEndpoint;
import fr.uga.l3miage.example.response.PartieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PartieController implements PartieEndpoint {
    @Override
    public void createEntityPartie(Long miahootId) {

    }

    @Override
    public List<PartieDTO> getAll() {
        return null;
    }
}
