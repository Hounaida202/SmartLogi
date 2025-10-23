package com.smartlogi.metiers;

import com.smartlogi.entities.Colis;
import com.smartlogi.entities.Livreur;
import com.smartlogi.services.ColisService;
import com.smartlogi.services.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component // ✅ Bean Spring
public class ColisMetier {

    @Autowired // ✅ Dependency Injection
    private ColisService colisService;

    public static void AddColis() {
        // ✅ IoC Container
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.smartlogi.config");

        // ✅ Récupération du bean via Spring
        ColisMetier colisMetier = context.getBean(ColisMetier.class);
        colisMetier.ajouterColisInteractif();

        context.close();
    }

    public void ajouterColisInteractif() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Adresse: ");
        String adresse = scanner.nextLine();

        System.out.print("Poids: ");
        double poids = scanner.nextDouble();
        scanner.nextLine();


        // ✅ Création du colis
        Colis colis = new Colis();
        colis.setDestination(destination);
        colis.setAdresse(adresse);
        colis.setPoids(poids);
        colis.setStatus(Colis.Status.PREPARE);

        try {
            // ✅ Ajout via Service (DI)
            Colis saved = colisService.ajouterColis(colis);
            System.out.println("✅ Colis ajouté! ID: " + saved.getId_colis());
        } catch (Exception e) {
            System.out.println("❌ Erreur: " + e.getMessage());
        }
    }

    public static void UpdatePackage() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.smartlogi.config");

        // Services
        LivreurService livreurService = context.getBean(LivreurService.class);
        ColisService colisService = context.getBean(ColisService.class);

        Scanner scanner = new Scanner(System.in);

        // --- Étape 1 : récupérer les IDs ---
        System.out.print("Entrer l'id du colis : ");
        Long idColis = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Entrer le nouvel id du livreur : ");
        Long idLivreur = scanner.nextLong();
        scanner.nextLine();

        // --- Étape 2 : vérifier existence colis ---
        Optional<Colis> colisOpt = colisService.trouverParId(idColis);
        if (colisOpt.isEmpty()) {
            System.out.println("❌ Colis non trouvé !");
            return;
        }

        // --- Étape 3 : vérifier existence livreur ---
        Optional<Livreur> livreurOpt = livreurService.trouverParId(idLivreur);
        if (livreurOpt.isEmpty()) {
            System.out.println("❌ Livreur non trouvé !");
            return;
        }

        // --- Étape 4 : modifier le FK ---
        Colis colis = colisOpt.get();
        Livreur livreur = livreurOpt.get();
        colis.setLivreur(livreur);

        // --- Étape 5 : sauvegarder ---
        colisService.ajouterColis(colis);

        System.out.println("Colis assigné au livreur !" + livreur.getId_livreur());
    }

}