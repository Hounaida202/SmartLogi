/*
package com.smartlogi.services;

import com.smartlogi.entities.Livreur;
import com.smartlogi.repositories.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivreurService {

    @Autowired
    private LivreurRepository livreurRepository;

    // ✅ Méthode pour ajouter un livreur
    public Livreur ajouterLivreur(Livreur livreur) {
        return livreurRepository.save(livreur);
    }
}
*/

package com.smartlogi.services;

import com.smartlogi.entities.Livreur;
import com.smartlogi.repositories.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
// ✅ Scope singleton par défaut (IoC)
public class LivreurService {

    @Autowired
    private LivreurRepository livreurRepository;

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
}
