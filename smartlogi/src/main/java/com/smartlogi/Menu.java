package com.smartlogi;


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
            System.out.println("9- quitter");
            choix = helper.verifierchoix(scanner, 1, 9);
            LivreurMetier as=new LivreurMetier();

            switch (choix) {
                case 1:
                    as.AddDilevery();
                    break;
                case 2:
                    System.out.println("programme exité");
                    break;
            }
        } while (choix != 2);
    }

}
