package lu.atozdigital.api.entities;

import javax.persistence.*;

@Entity
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    @Lob
    @Column(columnDefinition="BLOB")
    private byte[] picture;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
