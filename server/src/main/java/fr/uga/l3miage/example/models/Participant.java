package fr.uga.l3miage.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Participant extends Utilisateur {

    public Participant(Long userId, String userName, String login) {
        super(userId, userName, login);
    }
}

