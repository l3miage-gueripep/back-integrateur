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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String nom;

    String description;

    @ManyToMany(mappedBy = "miahootsConcus")
    List<Utilisateur> concepteurs;

    @ManyToMany(mappedBy = "miahootsPresentes")
    List<Utilisateur> presentateurs;

    @ManyToMany(mappedBy = "miahootsPaticipes")
    List<Utilisateur> participants;

    @OneToMany(mappedBy = "miahoot", cascade = CascadeType.ALL) //supprime toutes les questions du miahoot lorsqu'une est supprimée
    List<Question> questions;

    public void addQuestion(Question question){
        questions.add(question);
    }
}
