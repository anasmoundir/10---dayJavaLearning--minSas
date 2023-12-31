package services;
import DAO.AuthorDao;
import DAO.BookDao;
import DAO.ReservationDao;
import Entities.Auteur;
import Entities.Livre;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static DAO.BookDao.afficherTousLesLivres;


public class LivreService {



    public static void ajouterNouveauLivre(Scanner scanner) {
        boolean status = true;
        System.out.println("the list of all the authors");
        printAllAuteurs();
        System.out.println("Entrez le titre du livre : ");
        String titre = scanner.nextLine();
        System.out.println("Entrez l'année de publication : ");
        int anneePublication = scanner.nextInt();
        System.out.print("Entrez la quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Entrez la le nom de l'auteur : ");
        String nom = scanner.next();
        System.out.print("Entrez la l'ISBN de livre ");
        int ISBN = scanner.nextInt();
        if(quantite > 0)
        {
            status = true;

        }else
        {
            status = false;
        }

        Livre livre1 = new Livre();
        livre1.setQuantity(quantite);
        livre1.setAnnee_publication(anneePublication);
        livre1.setTitre(titre);
        livre1.setISBN(ISBN);
        livre1.setStatus(status);
        BookDao.insertQueryBook(livre1,nom);
    }

    public static void afficherLivresDisponibles() {

         List<Livre> livres = afficherTousLesLivres();

         int i =0;

         while(i<livres.size())
         {
             System.out.println(livres.get(i));
            i++;
         }
    }
    public static void printAllAuteurs() {
        List<Auteur> auteurs = AuthorDao.getAllAuteurs();

        if (auteurs.isEmpty()) {
            System.out.println("Aucun auteur disponible.");
        } else {
            System.out.println("Liste des auteurs disponibles :");
            for (Auteur auteur : auteurs) {
                System.out.println("ID : " + auteur.getId() + ", Nom : " + auteur.getName());

            }
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
                Livre livre = new Livre();
                livre = BookDao.rechercherLivresParTitre(titreRecherche);

                if (livre == null ) {
                    System.out.println("Aucun livre trouvé.");
                } else {
                    System.out.println("Liste des livres trouvés :");

                        System.out.println(livre);
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
                    for (Livre livre1 : livresParAuteur) {
                        System.out.println(livre1);
                    }
                }
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }

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
            afficherTousLesLivres();
            System.out.println("Entrez le titre du livre pour modifier le livre  : ");
            String titre = scanner.nextLine();
            System.out.println("Entrez l'annee de publication de livre ");
            int anne = scanner.nextInt();
            System.out.println("Entrez quantity de publication de livre ");
            int quantity = scanner.nextInt();
            System.out.println("Entrez le nom de l'auteur");
            String nom = scanner.next();
//            System.out.println("Entrez le status de livre");
            Boolean status = true;
            System.out.println("Entrez l'ISBN de livre");
            int ISBN = scanner.nextInt();
            Livre livre1 = new Livre();
            livre1.setTitre(titre);
            livre1.setQuantity(quantity);
            livre1.setAnnee_publication(anne);
            livre1.setStatus(status);
            livre1.setISBN(ISBN);
            BookDao.modifierLivre(livre1,nom);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public static void emprunterLivre(Scanner scanner) {
        System.out.println("La liste des livres disponibles :");
        afficherLivresDisponibles();
        System.out.println("Entrez le titre du livre que vous souhaitez emprunter :");
        String titre = scanner.nextLine();
        Livre livre = ReservationDao.emprunterLiveQuery(scanner, titre);
        if (livre != null) {
            System.out.println("Emprunt du livre réussi : " + livre.getTitre());
        }
    }






















}
