package fr.uga.l3miage.example.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String label;

    @ManyToOne
    Miahoot miahoot;

    @OneToMany
    private List<Reponse> reponses;

    public void addReponse(Reponse reponse){
        this.reponses.add(reponse);
    }




}
