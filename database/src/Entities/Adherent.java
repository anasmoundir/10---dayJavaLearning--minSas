package Entities;

import Entities.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Adherent {
    private int numero_membre;
    private String nom;
    private  int numero_telephone;
    private String Adress;
    private List<Reservation> reservations = new ArrayList<>();
    Adherent(int numero_membre,String nom,int numero_telephone,String Adress)
    {
        this.Adress = Adress;
        this.nom = nom;
        this.numero_membre = numero_membre;
        this.numero_telephone = numero_telephone;
    }
    Adherent()
    {

    }

    public int getNumero_membre() {
        return numero_membre;
    }

    public String getNom() {
        return nom;
    }

    public int getNumero_telephone() {
        return numero_telephone;
    }

    public String getAdress() {
        return Adress;
    }

    public void setNumero_membre(int numero_membre) {
        this.numero_membre = numero_membre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumero_telephone(int numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    @Override
    public String toString() {
        return "Adherent{" +
                "numero_membre=" + numero_membre +
                ", nom='" + nom + '\'' +
                ", numero_telephone=" + numero_telephone +
                ", Adress='" + Adress + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
