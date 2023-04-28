package fr.uga.l3miage.example.models;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private boolean estValide;

    @ManyToOne
    private Question question;
}
