package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.MiahootEndpoint;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.service.MiahootService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MiahootController implements MiahootEndpoint {
    private final MiahootService miahootService;

    @Override
    public void createEntityMiahoot(@Valid @RequestBody final CreateMiahootRequest request) {
        miahootService.createMiahoot(request);
    }

    @Override
    public List<MiahootDTO> getAll() {
        return miahootService.findAll();
    }

    @Override
    public MiahootDTO findById(Long id) {
        return miahootService.findById(id);
    }

    @Override
    public void deleteMiahoot(Long id) {
        miahootService.deleteById(id);
    }


}

