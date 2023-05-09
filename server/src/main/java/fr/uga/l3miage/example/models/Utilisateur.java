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
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String firebaseId;

    @ManyToMany
    List<Miahoot> miahootsConcus;

    @ManyToMany
    List<Miahoot> miahootsPresentes;

    @OneToMany(mappedBy = "participant")
    List<Session> sessions;

    @OneToMany(mappedBy = "presentateur")
    private List<Partie> parties;

    //@ManyToMany
    //List<Miahoot> miahootsParticipes;

    //@ManyToMany
    //private List<Reponse> reponses;

    public void addMiahootConcu(Miahoot miahoot){
        this.miahootsConcus.add(miahoot);
    }

    public void addMiahootPresente(Miahoot miahoot){
        this.miahootsPresentes.add(miahoot);
    }

    public void addPartie(Partie partie){
        this.parties.add(partie);
    }

    public Utilisateur() {
    }

    public Utilisateur(Long id, String userName, String firebaseId) {
        this.id = id;
        this.username = userName;
        this.firebaseId = firebaseId;
    }

    //public void addReponse(Reponse reponse){
    //    this.reponses.add(reponse);
    //}

    //public void addMiahootParticipe(Miahoot miahoot){
    //    this.miahootsParticipes.add(miahoot);
    //}
}

