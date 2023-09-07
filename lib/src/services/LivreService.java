package services;
import DAO.BookDao;
import Entities.Livre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static DAO.BookDao.afficherTousLesLivres;


public class LivreService {



    public static void ajouterNouveauLivre(Scanner scanner) {
        System.out.println("Entrez le titre du livre : ");
        String titre = scanner.nextLine();
        System.out.println("Entrez l'année de publication : ");
        int anneePublication = scanner.nextInt();
        System.out.print("Entrez la quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Entrez la le nom de l'auteur : ");
        String nom = scanner.next();
        Livre livre1 = new Livre();
        livre1.setQuantity(quantite);
        livre1.setAnnee_publication(anneePublication);
        livre1.setTitre(titre);
        BookDao.insertQueryBook(livre1,nom);
    }

    public static void afficherLivresDisponibles() {
         List<Livre> livres = afficherTousLesLivres();
//
//        for (Livre livre : livres) {
//            System.out.println(livre.toString());
//        }
         int i =0;

         while(i<livres.size())
         {
             System.out.println(livres.get(i));
            i++;
         }
    }




    public static void rechercherLivre(Scanner scanner) {
        System.out.println("Choisissez une option de recherche :");
        System.out.println("1. Rechercher par titre");
        System.out.println("2. Rechercher par auteur");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choix) {
            case 1:
                System.out.print("Entrez le titre du livre à rechercher : ");
                String titreRecherche = scanner.nextLine();
                List<Livre> livres = BookDao.rechercherLivresParTitre(titreRecherche);

                if (livres.isEmpty()) {
                    System.out.println("Aucun livre trouvé.");
                } else {
                    System.out.println("Liste des livres trouvés :");
                    for (Livre livre : livres) {
                        System.out.println(livre);
                    }
                }



                break;
            case 2:
                System.out.print("Entrez le nom de l'auteur à rechercher : ");
                String auteurRecherche = scanner.nextLine();
             List<Livre> livresParAuteur = BookDao.rechercherLivresParAuteur(auteurRecherche);
                if (livresParAuteur.isEmpty()) {
                    System.out.println("Aucun livre trouvé.");
                } else {
                    System.out.println("Liste des livres trouvés :");
                    for (Livre livre : livresParAuteur) {
                        System.out.println(livre);
                    }
                }
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }

    }

    public static void emprunterLivre(Scanner scanner) {

    }


    public static void retournerLivre(Scanner scanner) {

    }


    public static void afficherLivresEmpruntes() {

    }


    public static void supprimerLivre(Scanner scanner) {
        System.out.println("Entrez le titre du livre  pour supprimez votre livre: ");
        String titre = scanner.nextLine();
        Livre livre1 =new Livre();
        livre1.setTitre(titre);
        BookDao.supprimerLivre(livre1);
    }


    public static void modifierInformationsLivre(Scanner scanner) {
        try {
            System.out.println("Entrez le titre du livre pour modifier le livre  : ");
            String titre = scanner.nextLine();
            System.out.println("Entrez l'annee de publication de livre ");
            int anne = scanner.nextInt();
            System.out.println("Entrez quantity de publication de livre ");
            int quantity = scanner.nextInt();
            System.out.println("Entrez le nom de l'auteur");
            String nom = scanner.next();
            Livre livre1 = new Livre();
            livre1.setTitre(titre);
            livre1.setQuantity(quantity);
            livre1.setAnnee_publication(anne);
            BookDao.modifierLivre(livre1,nom);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
