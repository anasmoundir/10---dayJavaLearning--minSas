package services;
import DAO.BookDao;
import Entities.Livre;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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


    }


    public static void rechercherLivre(Scanner scanner) {

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
