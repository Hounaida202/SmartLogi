package com.smartlogi.metiers;

import com.smartlogi.entities.Livreur;
import com.smartlogi.repositories.LivreurRepository;
import com.smartlogi.services.LivreurService;
import com.smartlogi.validation.helper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;
import java.util.Scanner;

public class LivreurMetier {

    public static void AddDelivery(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.smartlogi.config");

        LivreurService service = context.getBean(LivreurService.class);


        Scanner scan = new Scanner(System.in);

        System.out.printf("ajouter le nom :");
        String nom = scan.nextLine();
        System.out.printf("ajouter le prenom :");
        String prenom = scan.nextLine();
        System.out.printf("ajouter le vehicule :");
        String vehicule = scan.nextLine();
            System.out.print("Ajouter le numéro de téléphone : ");
            long tele = scan.nextLong();
         scan.nextLine();

//        long tele;
//        do {
//            System.out.print("Ajouter le numéro de téléphone : ");
//            tele = scan.nextLong();
//            scan.nextLine();
//        } while (!helper.VerifyLong(String.valueOf(tele)));


        Livreur livreur = new Livreur(nom,prenom,vehicule,tele);
        String singleton1 = context.getBean("messageSingleton", String.class);
        String singleton2 = context.getBean("messageSingleton", String.class);
        System.out.println("Singleton même instance: " + (singleton1 == singleton2));


        Livreur saved = service.ajouterLivreur(livreur);
        System.out.println(" Livreur sauvegardé: " + saved.getId_livreur());
    }
    public static void DeleteDelivery() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.smartlogi.config");

        LivreurService service = context.getBean(LivreurService.class);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrer l'id du livreur: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // ✅ Important

        // ✅ Vérifier si existe
        Optional<Livreur> livreurOpt = service.trouverParId(id);

        if (livreurOpt.isPresent()) {
            // ✅ Supprimer
            service.supprimerLivreur(id);
            System.out.println("✅ Supprimé!");
        } else {
            System.out.println("❌ Non trouvé!");
        }
    }
    public static void UpdateDelivery() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.smartlogi.config");

        LivreurService service = context.getBean(LivreurService.class);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrer l'id du livreur à modifier: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        // ✅ Vérifier si existe
        Optional<Livreur> livreurOpt = service.trouverParId(id);

        if (livreurOpt.isPresent()) {
            Livreur livreur = livreurOpt.get();

            System.out.print("Nouveau nom: ");
            String nom = scanner.nextLine();
            livreur.setNom(nom);

            System.out.print("Nouveau prenom: ");
            String prenom = scanner.nextLine();
            livreur.setPrenom(prenom);

            System.out.print("Nouveau vehicule: ");
            String vehicule = scanner.nextLine();
            livreur.setVehicule(vehicule);

            System.out.print("Nouveau tele: ");
            long tele = scanner.nextLong();
            livreur.setTele(tele);

            // ✅ Modifier
            service.ajouterLivreur(livreur);
            System.out.println("✅ Modifié!");
        } else {
            System.out.println("❌ Non trouvé!");
        }
    }



}
