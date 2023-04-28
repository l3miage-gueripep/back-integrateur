package fr.uga.l3miage.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public abstract class Participant extends Utilisateur{


    private Long participantId;

    public Participant() {
    }

    public Participant(Long userId, String userName, String login) {
        super(userId,userName,login);
        this.participantId = userId;
    }

}
