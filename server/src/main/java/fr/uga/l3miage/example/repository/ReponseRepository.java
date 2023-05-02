package fr.uga.l3miage.example.repository;

import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.geom.RectangularShape;
import java.util.List;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse,Long> {
    List<Reponse> findAll();
    List<Reponse> findAllByLabel(final String label);
    @Override
    void deleteById(Long id);
}
