package fr.uga.l3miage.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Partie partie;

    @ManyToOne
    Utilisateur participant;

    @OneToMany(mappedBy = "session",cascade = CascadeType.ALL)
    List<Reponse> reponses;


}
