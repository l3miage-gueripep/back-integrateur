package fr.uga.l3miage.example.repository;


import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    @Override
    List<Question> findAll();

    Optional<Question> findById(Long id);

    List<Question> findAllByMiahoot(Miahoot miahoot);
}
