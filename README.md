#  Smart Delivery Management System

###  Introduction au projet

Le projet **Smart Delivery Management System** a été développé pour automatiser et simplifier la gestion des livraisons au sein de l’entreprise **SmartLogi**.  
Il permet de gérer efficacement les informations des **livreurs** et des **colis**, d’assurer un suivi fiable des livraisons, et d’améliorer la planification ainsi que la visibilité des opérations logistiques.


###  Objectifs du projet

- Gérer les informations des **livreurs** 
- Enregistrer et assigner des **colis** à des livreurs
- Mettre à jour le **statut** d’un colis : préparation, en transit, livré
- Lister les colis d’un livreur pour planifier les tournées
- Supprimer ou corriger les informations erronées



### Technologies utilisées

- **Java JDK 17**
- **Spring Core** (IoC, DI, Beans)
- **Spring Data JPA** 
- **PostgreSQL** 
- **Maven** 


## Structure du modèle de données

### Entités principales :

**Livreur**

**Colis**



### Fonctionnalités principales

- Ajouter, modifier, supprimer et lister des **livreurs**
- Ajouter un **colis** et l’assigner à un livreur
- Modifier le **statut** d’un colis
- Afficher la **liste des colis** d’un livreur



### Prérequis pour exécuter le projet

Avant de lancer le projet sur votre machine, assurez-vous d’avoir installé :

| Outil | Version recommandée | Rôle |
|-------|----------------------|------|
|  **JDK** | 17 ou supérieur | Compiler et exécuter le code Java |
|  **Maven** | Dernière version stable | Gérer les dépendances du projet |
|  **PostgreSQL** | 14+ | Base de données du projet |
|  **Apache Tomcat** | 10+ | Serveur d’exécution (si MVC activé) |
|  **Éditeur/IDE** | IntelliJ IDEA / Eclipse / VS Code | Environnement de développement |


## la diagramme des classes 
![Diagramm](smartlogi/src/main/java/UML/class_diagramm.jpeg)

---
