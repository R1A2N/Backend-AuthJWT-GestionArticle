package ma.fstt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Article  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private  Double price;

    public Long getId() {
        return id;
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




    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    private String image;

    public Categorie getCategorie() {
        return categorie;
    }

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @OneToMany (mappedBy = "article", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Image> images;

}
