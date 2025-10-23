package com.smartlogi.services;

import com.smartlogi.entities.Colis;
import com.smartlogi.repositories.ColisRepository;
import java.util.List;
import java.util.Optional;

public class ColisService {

    private ColisRepository colisRepository;

    // Injection par setter
    public void setColisRepository(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }

    public Colis ajouterColis(Colis colis) {
        return colisRepository.save(colis);
    }

    public Optional<Colis> trouverParId(Long id) {
        return colisRepository.findById(id);
    }

    public List<Colis> tousLesColis() {
        return colisRepository.findAll();
    }

    public List<Colis> trouverColisParLivreur(Long livreurId) {
        // Cette méthode nécessitera une implémentation custom dans le repository
        return colisRepository.findAll();
    }

    public Colis mettreAJourStatut(Long colisId, Colis.Status nouveauStatut) {
        Optional<Colis> colisOpt = colisRepository.findById(colisId);
        if (colisOpt.isPresent()) {
            Colis colis = colisOpt.get();
            colis.setStatus(nouveauStatut);
            return colisRepository.save(colis);
        }
        return null;
    }
}