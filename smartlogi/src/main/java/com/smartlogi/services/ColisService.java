package com.smartlogi.services;

import com.smartlogi.entities.Colis;
import com.smartlogi.entities.Livreur;
import com.smartlogi.repositories.ColisRepository;
import com.smartlogi.repositories.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ColisService {

    @Autowired
    private ColisRepository colisRepository;

    @Autowired
    private LivreurRepository livreurRepository;

    public Colis ajouterColis(Colis colis) {
        return colisRepository.save(colis);
    }

    public Optional<Colis> trouverParId(Long id) {
        return colisRepository.findById(id);
    }

    public List<Colis> tousLesColis() {
        return colisRepository.findAll();
    }

    public void modifierLivreurId(Long idColis, Long idLivreur) {
        Optional<Colis> colisOpt = colisRepository.findById(idColis);
        Optional<Livreur> livreurOpt = livreurRepository.findById(idLivreur);

        if (colisOpt.isEmpty()) {
            System.out.println("Colis non trouvé");
            return;
        }

        if (livreurOpt.isEmpty()) {
            System.out.println("Livreur non trouvé");
            return;
        }

        Colis colis = colisOpt.get();
        Livreur livreur = livreurOpt.get();
        colis.setLivreur(livreur);

        colisRepository.save(colis);

        System.out.println(" Livreur du colis mis à jour avec succès ");
    }
    public void modifierStatus(Long idColis, Colis.Status statut) {
        Optional<Colis> colisOpt = colisRepository.findById(idColis);
         if(colisOpt.isEmpty()){
             System.out.println(" Colis non trouvé");
         }
         else
         {
             Colis colis = colisOpt.get();
             colis.setStatus(statut);

             colisRepository.save(colis);
             System.out.println(" status du colis mis à jour avec succès ");

         }

    }
    public List<Colis> trouverColisParLivreur(Long livreurId) {
        return colisRepository.findByLivreurId(livreurId);
    }

}
