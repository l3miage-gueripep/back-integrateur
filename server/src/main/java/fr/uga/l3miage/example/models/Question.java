package fr.uga.l3miage.example.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String label;


    //@ManyToOne
    //private Miahoot miahoot;

    //@OneToMany(mappedBy = "question")
    //private List<Reponse> reponses;

}
