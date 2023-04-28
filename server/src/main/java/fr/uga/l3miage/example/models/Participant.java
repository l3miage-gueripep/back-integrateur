package fr.uga.l3miage.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Participant extends Utilisateur{

    public Participant() {
    }

    public Participant(Long userId, String userName, String login) {
        super(userId,userName,login);
    }

}
