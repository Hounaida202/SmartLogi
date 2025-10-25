package com.smartlogi.metiers;

import com.smartlogi.entities.Colis;
import com.smartlogi.entities.Livreur;
import com.smartlogi.services.ColisService;
import com.smartlogi.services.LivreurService;
import com.smartlogi.validation.helper;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.smartlogi.entities.Colis.Status.PREPARE;

public class ColisMetier{

    private ColisService colisService;
    private LivreurService livreurService;

    public ColisMetier(ColisService colisService){
        this.colisService=colisService;
    }

    public void addPackage(){
        System.out.print("ajouter la destination du colis");
        Scanner scan = new Scanner(System.in);
        String destination = scan.nextLine();

        System.out.print("ajouter l'adresse:");
        String adresse = scan.nextLine();

        double poids;
        do {
            System.out.print("Ajouter le poids : ");
            while (!scan.hasNextDouble()) {
                System.out.println("Entrez un poid valide ");
                scan.next();
            }
            poids = scan.nextDouble();
            if (poids <= 0) {
                System.out.println("Le poids doit être positif ");
            }
        } while (poids <= 0);

        Colis colis = new Colis(destination,adresse,poids,PREPARE,null);
        colisService.ajouterColis(colis);
    }
    public void updatePackageDelivery() {
        Scanner scan = new Scanner(System.in);
        Long id_colis;
        Long id_livreur;
        do {
            System.out.print("Ajouter l'id du colis : ");
            while (!scan.hasNextLong()) {
                System.out.println(" Entrez un id valide :");
                scan.next();
            }
            id_colis = scan.nextLong();
            if (id_colis <= 0) {
                System.out.println(" L'id doit être positif ");
            }
        } while (id_colis <= 0);

        do {
            System.out.print("Ajouter l'id du livreur : ");

            while (!scan.hasNextLong()) {
                System.out.println("Entrez un id valide ");
                scan.next();
            }
            id_livreur = scan.nextLong();
            if (id_livreur <= 0) {
                System.out.println(" L'id doit être positif !");
            }
        } while (id_livreur <= 0);
        colisService.modifierLivreurId(id_colis, id_livreur);
        /*LivreurService livr= new LivreurService();
        Optional<Livreur> liv = livr.trouverParId(id_livreur);*/

        System.out.println("le colis est bien assigné au livreur concerné ");
    }
    public void updateStatus() {
        Scanner scan = new Scanner(System.in);
        Long id_colis;
        do {
            System.out.print("Ajouter l'id du colis : ");
            while (!scan.hasNextLong()) {
                System.out.println(" Entrez un id valide :");
                scan.next();
            }
            id_colis = scan.nextLong();
            if (id_colis <= 0) {
                System.out.println(" L'id doit être positif ");
            }
        } while (id_colis <= 0);

        System.out.println("Choisir le statut : ");
        System.out.println("1 - PREPARE");
        System.out.println("2 - TRANSIT");
        System.out.println("3 - LIVRE");
        System.out.print("Votre choix : ");

        int choix = helper.verifierchoix(scan, 1, 3);
        Colis.Status status;

        switch (choix) {
            case 1:
                status = Colis.Status.PREPARE;
                break;
            case 2:
                status = Colis.Status.TRANSIT;
                break;
            case 3:
                status = Colis.Status.LIVRE;
                break;
            default:
                System.out.println("Choix invalide ");
                return;
        }
        colisService.modifierStatus(id_colis, status);

        System.out.println(" Statut mis à jour ");
    }

    public void afficherColisParLivreur() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Entrez l'id du livreur : ");
        Long livreurId = scan.nextLong();

        List<Colis> colisList = colisService.trouverColisParLivreur(livreurId);

        if (colisList.isEmpty()) {
            System.out.println("Aucun colis trouvé pour ce livreur.");
        } else {
            System.out.println("Liste des colis pour le livreur " + livreurId + " :");
            colisList.forEach(System.out::println);
        }
    }





}