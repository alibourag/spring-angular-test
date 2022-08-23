package lu.atozdigital.api.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @OneToMany
    List<Article> articles= new ArrayList<>();
    Date date;

    public void setId(Long id) {
        this.id = id;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Long getId() {
        return id;
    }
    public String getReference() {
        return reference;
    }
    public List<Article> getArticles() {
        return articles;
    }
    public Date getDate() {
        return date;
    }
}
