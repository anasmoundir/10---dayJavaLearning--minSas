package Entities;

import Entities.Livre;

import java.util.Date;

public class Reservation {



  private Date dateResrvation;
  private  Date dateLimite;

  LivreCopy livreCopy;
  Adherent adherent;





    public Reservation() {

    }
    public Reservation(Date dateResrvation, Date dateLimite) {
        this.dateResrvation = dateResrvation;
        this.dateLimite = dateLimite;
    }

    public Date getDateResrvation() {
        return dateResrvation;
    }

    public void setDateResrvation(Date dateResrvation) {
        this.dateResrvation = dateResrvation;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public Date getDateLimite() {
        return dateLimite;
    }


    public LivreCopy getLivreCopy() {
        return livreCopy;
    }

    public void setLivreCopy(LivreCopy livreCopy) {
        this.livreCopy = livreCopy;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    @Override
    public String toString() {
        return dateLimite+" "+dateResrvation;
    }
}
