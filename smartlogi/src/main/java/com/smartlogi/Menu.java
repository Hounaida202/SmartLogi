package com.smartlogi;

import com.smartlogi.metiers.LivreurMetier;
import com.smartlogi.services.ColisService;
import com.smartlogi.validation.helper;
import java.util.Scanner;

public class Menu {

    private LivreurMetier livreur;      // ✅ objet métier pour les livreurs
    private ColisService colisService;  // ✅ service pour les colis
    private Scanner scanner;            // ✅ pour lire les entrées utilisateur

    // ✅ Constructeur conforme à ton XML
    public Menu(ColisService colisService, LivreurMetier livreur) {
        this.colisService = colisService; // on garde la référence passée par Spring
        this.livreur = livreur;           // idem pour le métier
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Ajouter un livreur");
             System.out.println("2 - Supprimer un livreur");
            System.out.println("3 - Modifier un livreur");
            // System.out.println("4 - Ajouter un colis");
            // System.out.println("5 - Assigner un colis à un livreur");
            // System.out.println("6 - Assigner un colis à un livreur");



            System.out.println("6 - Quitter");
            System.out.print(" Votre choix : ");

            // Vérifie que le choix est compris entre 1 et 6
            choix = helper.verifierchoix(scanner, 1, 6);

            switch (choix) {
                case 1:
                    livreur.AddDelivery(); // ✅ on appelle la méthode du bean LivreurMetier
                    break;
                case 2:
                    livreur.deleteDelivery();
                    break;
                case 3:
                    livreur.modifyDelivery();
                    break;

                case 6:
                    System.out.println("🚪 Programme quitté. À bientôt !");
                    break;

                default:
                    System.out.println("⚠️ Option non encore implémentée !");
            }
        } while (choix != 6);
    }
}
