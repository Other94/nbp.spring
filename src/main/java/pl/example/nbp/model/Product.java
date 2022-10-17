package pl.example.nbp.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @NotNull(message = "Pole nie może być puste")
    private String productName;

    @NotNull(message = "Pole nie może być puste")
    private Date postingDate;

    @NotNull(message = "Pole nie może być puste")
    private double priceUSD;

    private double pricePLN;

    public Product() {
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public double getPricePLN() {
        return pricePLN;
    }

    public void setPricePLN(double pricePLN) {
        this.pricePLN = pricePLN;
    }
}
