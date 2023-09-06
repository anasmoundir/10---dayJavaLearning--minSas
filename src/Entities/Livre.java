package Entities;

import java.util.ArrayList;
import java.util.List;

public class Livre {
    private int numeroIsbn;
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




    public Livre(int numeroIsbn,String titre,int Quantity, boolean status)
    {
        this.numeroIsbn = numeroIsbn;
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

    public void setNumeroIsbn(int numeroIsbn) {
        this.numeroIsbn = numeroIsbn;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return numeroIsbn+" "+quantity+" "+titre;
    }
}
