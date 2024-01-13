package ma.fstt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Article  {


    @Id
    private Long id;
    private String description;
    private  Double price;

    public Long getId() {
        return id;
    }

    public Article(String description, Double price, String image) {
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Article(Long id, String description, Double price, String image) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Article() {
    }

    public void setId(Long id) {
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

    public Categorie getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Categorie catalogue) {
        this.catalogue = catalogue;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    private String image;
    @ManyToOne
    @JoinColumn(name = "catalogue_id")
    @JsonBackReference
    private Categorie catalogue;

    @OneToMany (mappedBy = "article", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Image> images;

}
