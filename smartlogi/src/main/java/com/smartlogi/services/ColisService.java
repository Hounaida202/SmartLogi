package com.smartlogi.services;

import com.smartlogi.entities.Colis;
import com.smartlogi.repositories.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public class ColisService {

    private ColisRepository colisRepository;

    public void setColisRepository(ColisRepository colisRepository){
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
        return colisRepository.findByLivreurId(livreurId);
    }
}
