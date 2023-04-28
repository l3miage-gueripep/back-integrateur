package fr.uga.l3miage.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String login;

    public Utilisateur() {
    }

    public Utilisateur(Long userId, String userName, String login) {
        this.userId = userId;
        this.userName = userName;
        this.login = login;
    }
}
