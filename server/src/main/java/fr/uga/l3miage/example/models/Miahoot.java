package fr.uga.l3miage.example.models;


import javax.persistence.*;

@Entity
public class Miahoot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String nom;
}
