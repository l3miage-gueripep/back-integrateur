package fr.uga.l3miage.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String firebaseId;

    @ManyToMany
    List<Miahoot> miahootsConcus;

    @ManyToMany
    List<Miahoot> miahootsPresentes;

    @ManyToMany
    List<Miahoot> miahootsParticipes;



    public Utilisateur() {
    }

    public Utilisateur(Long userId, String userName, String login) {
        this.Id = userId;
        this.username = userName;
        this.firebaseId = firebaseId;
    }
}

