package com.smartlogi.services;

import com.smartlogi.entities.Colis;
import com.smartlogi.entities.Livreur;
import com.smartlogi.repositories.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service // ✅ Bean Spring
public class ColisService {

    @Autowired // ✅ Dependency Injection
    private ColisRepository colisRepository;


    public Colis ajouterColis(Colis colis) {
         return colisRepository.save(colis); // Sauvegarder le colis
    }

    public Optional<Colis> trouverParId(Long id) {
        return colisRepository.findById(id);
    }

}