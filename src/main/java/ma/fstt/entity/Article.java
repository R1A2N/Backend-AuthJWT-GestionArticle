package ma.fstt.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
public class Article {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    private Double prix;

    private  String image;
}
