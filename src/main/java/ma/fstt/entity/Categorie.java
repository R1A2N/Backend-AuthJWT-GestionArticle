package ma.fstt.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
public class Categorie {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private  String image;
}
