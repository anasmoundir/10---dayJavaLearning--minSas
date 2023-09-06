package Entities;

import java.util.ArrayList;
import java.util.List;

public class Livre {
    private int numeroIsbn;
    private String titre;
    private int quantity;
    private boolean status;

    private List<LivreCopy> Livres = new ArrayList<>();
     private Auteur auteur;



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

    @Override
    public String toString() {
        return numeroIsbn+" "+quantity+" "+titre;
    }
}
