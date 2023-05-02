package fr.uga.l3miage.example.repository;

import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.geom.RectangularShape;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse,Long> {
    @Override
    List<Reponse> findAll();

    @Override
    Optional<Reponse> findById(Long id);

    List<Reponse> findAllByQuestion(Question question);
}
