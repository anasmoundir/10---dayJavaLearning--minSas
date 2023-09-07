package Entities;

import java.util.ArrayList;
import java.util.List;

public class Livre {

    private String titre;
    private int quantity;
    private boolean status;
    private  int annee_publication;

    Auteur auteur;
    public void setAnnee_publication(int annee_publication) {
        this.annee_publication = annee_publication;
    }

    public int getAnnee_publication() {
        return annee_publication;
    }

    public Livre(String titre,int Quantity, boolean status)
    {

        this.titre = titre;
        this.quantity = quantity;
        this.status = status;
    }
    public Livre()
    {
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    public int getQuantity() {
        return quantity;
    }

    public String getTitre() {
        return titre;
    }


    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return""+ '\'' +
                "titre='" + titre + '\'' +
                ", quantity=" + quantity +
                ", annee_publication=" + annee_publication +
                ", auteur=" + auteur.getName()
                +"";
    }
}
