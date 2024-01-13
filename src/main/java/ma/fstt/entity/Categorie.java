package ma.fstt.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Categorie {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Categorie() {
    }

    public Categorie(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Categorie(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "catalogue", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Article> artcles;

}
