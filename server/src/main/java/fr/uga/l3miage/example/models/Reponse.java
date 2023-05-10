package fr.uga.l3miage.example.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private boolean estCorrect;

    @ManyToOne
    @JoinColumn(name = "question.id")
    private Question question;

    @ManyToOne
    Session session;

    //@ManyToMany
    //private List<Utilisateur> utilisateurs;
/*
    public void addUtilisateur(Utilisateur utilisateur){
        this.utilisateurs.add(utilisateur);
    }
 */
}
