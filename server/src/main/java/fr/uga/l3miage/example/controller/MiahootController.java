package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.MiahootEndpoint;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.service.MiahootService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MiahootController implements MiahootEndpoint {
    private final MiahootService miahootService;

    @Override
    public void createEntityMiahoot(final String description) {
        log.warn("{}",description);
        //miahootService.createMiahoot(request);
    }

}

