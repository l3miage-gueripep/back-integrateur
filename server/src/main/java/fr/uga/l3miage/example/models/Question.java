package fr.uga.l3miage.example.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String label;

    @ManyToOne
    private Miahoot miahoot;

    @OneToMany(mappedBy = "question")
    private List<Reponse> reponses;


}
