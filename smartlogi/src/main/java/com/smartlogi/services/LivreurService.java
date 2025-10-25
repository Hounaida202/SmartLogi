package com.smartlogi.services;

import com.smartlogi.entities.Livreur;
import com.smartlogi.repositories.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public class LivreurService {

    private LivreurRepository livreurRepository;


    public void setLivreurRepository (LivreurRepository livreurRepository){
        this.livreurRepository = livreurRepository;

    }




    public Livreur ajouterLivreur(Livreur livreur) {
         return livreurRepository.save(livreur);

    }

    public void tousLesLivreurs() {
        List<Livreur> livreurs = livreurRepository.findAll();
        livreurs.forEach(System.out::println);

    }

    public Optional<Livreur> trouverParId(Long id) {
        return livreurRepository.findById(id);
    }

    public void supprimerLivreur(Long id) {
       Optional <Livreur> find = livreurRepository.findById(id);
        if(find.isPresent()){
            livreurRepository.deleteById(id);
        }
        else
            System.out.print("id n existe pas");
    }

    public Livreur mettreAJourLivreur(Livreur livreur) {
        return livreurRepository.save(livreur);
    }
}
