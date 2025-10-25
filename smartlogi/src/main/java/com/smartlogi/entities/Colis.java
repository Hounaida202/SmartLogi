package com.smartlogi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import static org.hibernate.engine.jdbc.spi.TypeNullability.NULLABLE;

@Entity
public class Colis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String destination;
    private String adresse;
    private double poids;

    public enum Status {
        PREPARE, TRANSIT, LIVRE
    }

    @Enumerated(EnumType.STRING)
    private Status status;

    // Relation : plusieurs colis pour un livreur
    @ManyToOne
    @JoinColumn(name = "id_livreur", nullable = true)
    private Livreur livreur;

    public Colis() {}

    public Colis(String destination, String adresse, double poids, Status status, Livreur livreur) {
        this.destination = destination;
        this.adresse = adresse;
        this.poids = poids;
        this.status = status;
        this.livreur = livreur;
    }

    public long getId_colis() {
        return ID;
    }

    public void setId_colis(Long id_colis) {
        this.ID = id_colis;
    }

    public String getDestination() {
        return destination;}
    public void setDestination(String destination) {
        this.destination = destination;}
    public String getAdresse() {
        return adresse;}
    public void setAdresse(String adresse) {
        this.adresse = adresse;}
    public double getPoids() {
        return poids;}
    public void setPoids(double poids) {
        this.poids = poids;}
    public Status getStatus() {
        return status;}
    public void setStatus(Status status) {
        this.status = status;}
    public Livreur getLivreur() {
        return livreur;
    }
    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }
}
