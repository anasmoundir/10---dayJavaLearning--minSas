package Entities;

import Entities.Livre;

import java.util.ArrayList;
import java.util.List;

public class Auteur {

    private String name;
    private String adress;


    private List<Livre> Books = new ArrayList<>();

    public List<Livre> getBooks() {
        return Books;
    }

    public void setBooks(List<Livre> books) {
        Books = books;
    }

    public Auteur(String name, String adress)
    {
        this.name = name;
        this.adress = adress;
    }
    public Auteur()
    {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    public void ajouter(Livre livre)
    {
        Livre livre1 =new Livre();
        Books.add(livre1);
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", Books=" + Books +
                '}';
    }


}
