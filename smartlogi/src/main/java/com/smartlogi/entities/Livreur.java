package com.smartlogi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "livreurs")
public class Livreur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // au lieu de id_livreur


    private String nom;
    private String prenom;
    private String vehicule;
    private Long tele;

    //  Un livreur peut avoir plusieurs colis
    @OneToMany(mappedBy = "livreur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Colis> colisList;

    //  Constructeurs
    public Livreur() {}

    public Livreur(String nom, String prenom, String vehicule, long tele) {
        this.nom = nom;
        this.prenom = prenom;
        this.vehicule = vehicule;
        this.tele = tele;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVehicule() {
        return vehicule;
    }
    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;}
    public long getTele() {
        return tele;}
    public void setTele(long tele) {
        this.tele = tele;
    }
    public List<Colis> getColisList() {
        return colisList;
    }
    public void setColisList(List<Colis> colisList) {
        this.colisList = colisList;
    }


    @Override
    public String toString() {
        return "Livreur{" +
                "id_livreur=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", vehicule='" + vehicule + '\'' +
                ", tele=" + tele +
                '}';
    }
}
