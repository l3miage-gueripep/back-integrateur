package fr.uga.l3miage.example.models;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Miahoot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String nom;
}
