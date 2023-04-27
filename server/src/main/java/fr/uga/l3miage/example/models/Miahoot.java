package fr.uga.l3miage.example.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Miahoot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String nom;

    String description;

    @OneToMany
    List<Question> questions;

    public void addQuestion(Question question){
        questions.add(question);
    }
}
