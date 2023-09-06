package Entities;

import Entities.Livre;

import java.util.Date;

public class Reservation {



  private Date dateResrvation;
  private  Date dateLimite;

  Auteur auteur;
  Livre livre;



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

    @Override
    public String toString() {
        return dateLimite+" "+dateResrvation;
    }
}
