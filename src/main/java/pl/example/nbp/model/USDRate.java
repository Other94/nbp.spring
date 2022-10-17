package pl.example.nbp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class USDRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsdRate;

    private Date date;

    private double usdRate;

    public int getIdUsdRate() {
        return idUsdRate;
    }

    public void setIdUsdRate(int idUsdRate) {
        this.idUsdRate = idUsdRate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(double usdRate) {
        this.usdRate = usdRate;
    }
}
