import java.util.Scanner;
import services.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            afficherMenuPrincipal();

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    gestionLivres(scanner);
                    break;
                case 2:
                    gestionReservations(scanner);
                    break;
                case 3:
                    genererRapport();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void afficherMenuPrincipal() {
        System.out.println("===== Menu Principal =====");
        System.out.println("1. Gestion des livres");
        System.out.println("2. Gestion des réservations");
        System.out.println("3. Générer un rapport");
        System.out.println("4. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void gestionLivres(Scanner scanner) {
        while (true) {
            System.out.println("===== Menu Gestion des Livres =====");
            System.out.println("1. Ajouter un nouveau livre");
            System.out.println("2. Afficher les livres disponibles");
            System.out.println("3. Rechercher un livre");
            System.out.println("4. Emprunter un livre");
            System.out.println("5. Retourner un livre emprunté");
            System.out.println("6. Afficher les livres empruntés");
            System.out.println("7. Supprimer un livre");
            System.out.println("8. Modifier les informations d'un livre");
            System.out.println("9. Retour au menu principal");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    LivreService.ajouterNouveauLivre(scanner);
                    break;
                case 2:
                    LivreService.afficherLivresDisponibles();
                    break;
                case 3:
                    LivreService.rechercherLivre(scanner);
                    break;
                case 4:
                    LivreService.emprunterLivre(scanner);
                    break;
                case 5:
                    LivreService.retournerLivre(scanner);
                    break;
                case 6:
                    LivreService.afficherLivresEmpruntes();
                    break;
                case 7:
                    LivreService.supprimerLivre(scanner);
                    break;
                case 8:
                    LivreService.modifierInformationsLivre(scanner);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void gestionReservations(Scanner scanner) {
    }

    private static void genererRapport() {

    }
}