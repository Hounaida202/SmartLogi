package com.smartlogi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "livreurs")
public class Livreur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livreur;

    private String nom;
    private String prenom;
    private String vehicule;
    private long tele;

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

    //  Getters et setters
    public Long getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(Long id_livreur) {
        this.id_livreur = id_livreur;
    }

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
                "id_livreur=" + id_livreur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", vehicule='" + vehicule + '\'' +
                ", tele=" + tele +
                '}';
    }
}
