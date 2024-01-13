package ma.fstt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class Article  {


    @Id
    private Integer id;
    private String description;
    private  Double price;

    public Integer getId() {
        return id;
    }

    public Article(String description, Double price, String image) {
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Article(Integer id, String description, Double price, String image) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Article() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
    @Lob
    @Column(name = "image_data", columnDefinition = "BLOB")
    private byte[] imageData;


    private String image;
    @ManyToOne
    @JoinColumn(name = "catalogue_id")
    @JsonBackReference
    private Categorie catalogue;

}
