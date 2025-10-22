package com.smartlogi.validation;



import java.util.Scanner;

public class helper {

    public static int verifierchoix(Scanner scanner, int min, int max) {
        int choix;
        while (true) {
            System.out.print("Choix : ");
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine();
                if (choix >= min && choix <= max) {
                    return choix;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("choix invalide");
        }
    }}