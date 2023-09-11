package services;


import DAO.ReservationDao;
import Entities.Livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static DAO.ReservationDao.emprunterLiveQuery;
import static services.LivreService.afficherLivresDisponibles;

public class ReservationService {

    static Connection connection = Database.getConnection();

        public static void emprunterLivre(Scanner scanner) {
        Livre livre = new Livre();
        System.out.println("la liste des livre disponible");
        afficherLivresDisponibles();
        System.out.println("entrez le titre de livre souhaitez");
        String titre = scanner.nextLine();
        livre = ReservationDao.emprunterLiveQuery(scanner,titre);
        System.out.println(livre.getTitre());
    }







    public static void updateLivreCopyState(int livreCopyId, int newState) throws SQLException {


    }





    public static void retournerLivre(Scanner scanner) {
        System.out.println("===== Retourner un livre emprunté =====");
        System.out.print("Entrez le titre du livre que vous souhaitez retourner : ");
        String titre = scanner.nextLine();
        ReservationDao.retournerLivreQuery(scanner, titre);
    }










}
