package fr.uga.l3miage.example.repository;


import fr.uga.l3miage.example.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findAllByLabel(final String label);
}
