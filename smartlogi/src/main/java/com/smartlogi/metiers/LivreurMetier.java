package com.smartlogi.metiers;

import com.smartlogi.entities.Livreur;
import com.smartlogi.services.LivreurService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class LivreurMetier {

    public static void AddDilevery(){
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
        System.out.printf("ajouter le tele :");
        long tele = scan.nextLong();
        scan.nextLine();

        Livreur livreur = new Livreur(nom,prenom,vehicule,tele);
        String singleton1 = context.getBean("messageSingleton", String.class);
        String singleton2 = context.getBean("messageSingleton", String.class);
        System.out.println("Singleton même instance: " + (singleton1 == singleton2));


        Livreur saved = service.ajouterLivreur(livreur);
        System.out.println(" Livreur sauvegardé: " + saved.getId_livreur());
    }
}
