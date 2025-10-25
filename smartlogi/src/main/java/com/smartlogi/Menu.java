package com.smartlogi;

import com.smartlogi.entities.Colis;
import com.smartlogi.metiers.ColisMetier;
import com.smartlogi.metiers.LivreurMetier;
import com.smartlogi.services.ColisService;
import com.smartlogi.validation.helper;
import java.util.Scanner;

public class Menu {

    private LivreurMetier livreur;
    private ColisMetier colis;
    private Scanner scanner;

    public Menu(LivreurMetier livreur , ColisMetier colis) {
        this.livreur = livreur;
        this.colis = colis;
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix;
        do {
            System.out.println("\n-----------MENU----------");
            System.out.println("1 - Ajouter un livreur");
             System.out.println("2 - Supprimer un livreur");
            System.out.println("3 - Modifier un livreur");
             System.out.println("4 - Ajouter un colis");
            System.out.println("5 - Assigner un colis à un livreur");

             System.out.println("6 - Modifier le statut");

            System.out.println("7 - lister les colis d'un livreur");


            System.out.println("8 - Quitter");
            System.out.print(" Votre choix : ");

            choix = helper.verifierchoix(scanner, 1, 8);

            switch (choix) {
                case 1:
                    livreur.AddDelivery();
                    break;
                case 2:
                    livreur.deleteDelivery();
                    break;
                case 3:
                    livreur.modifyDelivery();
                    break;
                case 4:
                    colis.addPackage();
                    break;
                case 5:
                    colis.updatePackageDelivery();
                    break;
                case 6:
                    colis.updateStatus();
                    break;
                case 7:
                    colis.afficherColisParLivreur();
                    break;

                case 8:
                    System.out.println("bye :(");
                    break;

                default:
                    System.out.println("Option n existe pas ");
            }
        } while (choix != 8);
    }
}
