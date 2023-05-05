package fr.uga.l3miage.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Partie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    Boolean isActive;

    @ManyToOne
    Miahoot miahoot;

    @OneToMany
    List<Session> sessions;

    public Partie(){
        this.isActive = false;
        this.date = new Date();
    }
}
