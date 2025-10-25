package com.smartlogi.metiers;

import com.smartlogi.entities.Livreur;
import com.smartlogi.services.LivreurService;
import java.util.Scanner;

public class LivreurMetier {

    private final LivreurService livreurService;

    public LivreurMetier(LivreurService livreurService){
        this.livreurService = livreurService;
    }

    public void AddDelivery(){
        Scanner scan = new Scanner(System.in);

        System.out.print("ajouter le nom : ");
        String nom = scan.nextLine();

        System.out.print("ajouter le prenom : ");
        String prenom = scan.nextLine();

        System.out.print("ajouter le vehicule : ");
        String vehicule = scan.nextLine();

        long tele;
        do {
            System.out.print("Ajouter le numéro de téléphone : ");
            while (!scan.hasNextLong()) {
                System.out.println("Entrez un numero valide !");
                scan.next();
            }
            tele = scan.nextLong();
            if (tele <= 0) {
                System.out.println(" Le numéro doit être positif ");
            }
            scan.nextLine();
        } while (tele <= 0);
        Livreur livreur = new Livreur(nom, prenom, vehicule, tele);
        Livreur saved = livreurService.ajouterLivreur(livreur);
        System.out.println( saved.getId());
    }
    public void deleteDelivery(){
        Scanner scan = new Scanner(System.in);

        System.out.print("ajouter l id de livreur a supprimer : ");
        Long id = scan.nextLong();

         livreurService.supprimerLivreur(id);
        System.out.print("supprimé avec succes  ");

    }

    public void modifyDelivery() {
        Scanner scan = new Scanner(System.in);

        System.out.print(" Entrez l'ID du livreur à modifier : ");
        Long id = scan.nextLong();
        scan.nextLine();

        System.out.print("Nouveau nom : ");
        String nom = scan.nextLine();

        System.out.print("Nouveau prénom : ");
        String prenom = scan.nextLine();

        System.out.print("Nouveau véhicule : ");
        String vehicule = scan.nextLine();

        System.out.print("Nouveau téléphone : ");
        Long tele = scan.nextLong();

        Livreur livreur = livreurService.trouverParId(id).get();

        livreur.setNom(nom);
        livreur.setPrenom(prenom);
        livreur.setVehicule(vehicule);
        livreur.setTele(tele);

        livreurService.mettreAJourLivreur(livreur);

        System.out.println("Livreur mis à jour avec succès !");
    }


}
