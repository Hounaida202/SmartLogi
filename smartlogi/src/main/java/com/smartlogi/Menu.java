package com.smartlogi;


import com.smartlogi.metiers.ColisMetier;
import com.smartlogi.metiers.LivreurMetier;
import com.smartlogi.validation.helper;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }
    public void afficherMenu() {
        int choix;
        do {
            System.out.println("1-Ajouter livreur");
            System.out.println("2-supprimer livreur");
            System.out.println("3-modifier livreur");
            System.out.println("4-add colis");

            System.out.println("5- quitter");
            choix = helper.verifierchoix(scanner, 1, 9);
            LivreurMetier as=new LivreurMetier();
            ColisMetier Cs=new ColisMetier();

            switch (choix) {
                case 1:
                    as.AddDelivery();
                    break;
                case 2:
                    as.DeleteDelivery();
                    break;
                case 3:
                    as.UpdateDelivery();
                    break;
                case 4:
                    Cs.AddColis();
                    break;

                case 5:
                    System.out.println("programme exité");
                    break;
            }
        } while (choix != 5);
    }

}
