package com.smartlogi;

import com.smartlogi.entities.Livreur;
import com.smartlogi.services.LivreurService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Menu menu = context.getBean(Menu.class);


       menu.afficherMenu();

//        livreurService.ajouterLivreur(new Livreur("hh","hh","hh",6777777));

    }
}