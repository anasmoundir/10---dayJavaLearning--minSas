import java.time.LocalDateTime;
import java.util.Date;

public class Reservation {



  private LocalDateTime dateResrvation;
  private  LocalDateTime dateLimite;

    public Reservation() {

    }
    public Reservation(LocalDateTime dateResrvation, LocalDateTime dateLimite) {
        this.dateResrvation = dateResrvation;
        this.dateLimite = dateLimite;
    }

    public LocalDateTime getDateResrvation() {
        return dateResrvation;
    }

    public void setDateResrvation(LocalDateTime dateResrvation) {
        this.dateResrvation = dateResrvation;
    }

    public void setDateLimite(LocalDateTime dateLimite) {
        this.dateLimite = dateLimite;
    }

    public LocalDateTime getDateLimite() {
        return dateLimite;
    }
}
