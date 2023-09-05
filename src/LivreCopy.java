import java.util.List;

public class LivreCopy extends Livre {
    private String nom;
    private boolean status;
    public LivreCopy(String nom, boolean status)
    {
        this.status = status;
        this.nom = nom;
    }
    public LivreCopy()
    {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
    return nom +" "+status;
    }
}
