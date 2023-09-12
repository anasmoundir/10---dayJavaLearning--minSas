package Entities;

import java.util.ArrayList;
import java.util.List;

public class Livre {

    private int id_livre;
    private String titre;
    private int quantity;
    private boolean status;
    private int annee_publication;
    private int ISBN;
    private Auteur auteur;

    public Livre(String titre, int quantity, boolean status,int annee_publication,int ISBN) {
        this.ISBN =ISBN;
        this.titre = titre;
        this.quantity = quantity;
        this.status = status;
        this.annee_publication = annee_publication;
    }

    public Livre() {
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        if (titre != null && !titre.isEmpty()) {
            this.titre = titre;
        } else {
            System.out.println("Titre invalide.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantité invalide.");
        }
    }

    public int getAnnee_publication() {
        return annee_publication;
    }

    public void setAnnee_publication(int annee_publication) {
        // Validate that the publication year is within a reasonable range
        int currentYear = java.time.Year.now().getValue();
        if (annee_publication >= 0 && annee_publication <= currentYear) {
            this.annee_publication = annee_publication;
        } else {
            System.out.println("Année de publication invalide.");
        }
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        if (ISBN > 0) {
            this.ISBN = ISBN;
        } else {
            System.out.println("ISBN invalide.");
        }
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", quantity=" + quantity +
                ", annee_publication=" + annee_publication +
                ", auteur=" + (auteur != null ? auteur.getName() : "Inconnu") +
                '}';
    }
}