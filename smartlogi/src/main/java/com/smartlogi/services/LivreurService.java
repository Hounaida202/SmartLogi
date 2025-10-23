package com.smartlogi.services;

import com.smartlogi.entities.Livreur;
import com.smartlogi.repositories.LivreurRepository;
import java.util.List;
import java.util.Optional;

public class LivreurService {

    private LivreurRepository livreurRepository;

    // Injection par setter
    public void setLivreurRepository(LivreurRepository livreurRepository) {
        this.livreurRepository = livreurRepository;
    }

    public Livreur ajouterLivreur(Livreur livreur) {
        return livreurRepository.save(livreur);
    }

    public List<Livreur> tousLesLivreurs() {
        return livreurRepository.findAll();
    }

    public Optional<Livreur> trouverParId(Long id) {
        return livreurRepository.findById(id);
    }

    public void supprimerLivreur(Long id) {
        livreurRepository.deleteById(id);
    }

    public Livreur mettreAJourLivreur(Livreur livreur) {
        return livreurRepository.save(livreur);
    }
}