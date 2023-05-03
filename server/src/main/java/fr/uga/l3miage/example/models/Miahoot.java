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

    @OneToMany(mappedBy = "miahoot", cascade = CascadeType.ALL) //supprime toutes les questions du miahoot lorsqu'une est supprimée
    List<Question> questions;

    @ManyToMany(mappedBy = "miahootsConcus")
    List<Utilisateur> concepteurs;

    @ManyToMany(mappedBy = "miahootsPresentes")
    List<Utilisateur> presentateurs;

    @ManyToMany(mappedBy = "miahootsParticipes")
    List<Utilisateur> participants;

    public void addQuestion(Question question){
        questions.add(question);
    }

    public void addConcepteur(Utilisateur concepteur){
        this.concepteurs.add(concepteur);
    }

    public void addPresentateur(Utilisateur presentateur){
        this.presentateurs.add(presentateur);
    }

    public void addParticipant(Utilisateur participant){
        this.participants.add(participant);
    }
}
