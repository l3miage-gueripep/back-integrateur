package fr.uga.l3miage.example.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Presentateur extends Utilisateur {

    public Presentateur(Long userId, String userName, String login) {
        super(userId, userName, login);

    }
}

