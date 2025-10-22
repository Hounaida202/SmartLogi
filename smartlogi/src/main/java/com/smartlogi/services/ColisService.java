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

    @Autowired // ✅ DI du LivreurService
    private LivreurService livreurService;

    public Colis ajouterColis(Colis colis, Long livreurId) {
        // ✅ Récupérer le livreur via le service
        Optional<Livreur> livreurOpt = livreurService.trouverParId(livreurId);

        if (livreurOpt.isPresent()) {
            colis.setLivreur(livreurOpt.get()); // Associer le colis au livreur
            return colisRepository.save(colis); // Sauvegarder le colis
        }
        throw new RuntimeException("Livreur non trouvé avec ID: " + livreurId);
    }
}