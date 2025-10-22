package com.smartlogi.metiers;

import com.smartlogi.entities.Colis;
import com.smartlogi.services.ColisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
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

        System.out.print("ID du livreur: ");
        Long livreurId = scanner.nextLong();
        scanner.nextLine();

        // ✅ Création du colis
        Colis colis = new Colis();
        colis.setDestination(destination);
        colis.setAdresse(adresse);
        colis.setPoids(poids);
        colis.setStatus(Colis.Status.PREPARE);

        try {
            // ✅ Ajout via Service (DI)
            Colis saved = colisService.ajouterColis(colis, livreurId);
            System.out.println("✅ Colis ajouté! ID: " + saved.getId_colis());
        } catch (Exception e) {
            System.out.println("❌ Erreur: " + e.getMessage());
        }
    }
}