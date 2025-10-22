/*
package com.smartlogi;

import com.smartlogi.entities.Livreur;
import com.smartlogi.services.LivreurService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        LivreurService livreurService = context.getBean(LivreurService.class);

        Livreur livreur = new Livreur();
        livreur.setNom("Ali");
        livreur.setPrenom("Ben Salah");
        livreur.setVehicule("Moto");
        livreur.setTele(600112233L);

        livreurService.ajouterLivreur(livreur);
        System.out.println("✅ Livreur ajouté avec succès !");
    }
}*/
package com.smartlogi;

import com.smartlogi.entities.Livreur;
import com.smartlogi.services.LivreurService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/*

public class Main {
    public static void main(String[] args) {
        // ✅ Utilisation de la configuration Java (IoC Container)
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.smartlogi.config");

        // ✅ Récupération du bean LivreurService (DI)
        LivreurService livreurService = context.getBean(LivreurService.class);

        // ✅ Création d'un livreur
        Livreur livreur = new Livreur();
        livreur.setNom("Ali");
        livreur.setPrenom("Ben Salah");
        livreur.setVehicule("Moto");
        livreur.setTele(600112233L);

        // ✅ Persistance avec Spring Data JPA
        Livreur savedLivreur = livreurService.ajouterLivreur(livreur);

        System.out.println("✅ Livreur ajouté avec ID: " + savedLivreur.getId_livreur());

        context.close();
    }
}
*/

import com.smartlogi.metiers.LivreurMetier;

import static java.awt.SystemColor.menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.afficherMenu();
        /*  AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.smartlogi.config");

        LivreurService service = context.getBean(LivreurService.class);*/

        // Test des scopes
       /* String singleton1 = context.getBean("messageSingleton", String.class);
        String singleton2 = context.getBean("messageSingleton", String.class);
        System.out.println("Singleton même instance: " + (singleton1 == singleton2));


        Livreur saved = service.ajouterLivreur(livreur);
        System.out.println(" Livreur sauvegardé: " + saved.getId_livreur());*/

//        service.tousLesLivreurs().forEach(System.out::println);
//
//        context.close();
    }
}
