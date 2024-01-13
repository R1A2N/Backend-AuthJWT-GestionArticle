package ma.fstt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class Image {
    @Id
    @GeneratedValue
    private long id;
    private String imageName;
    private String imageUrl;
    @Lob
    @Column(name = "image_data", columnDefinition = "BLOB")
    private byte[] imageData;

    public Image() {
    }

    public Image(long id, String imageName, String imageUrl, byte[] imageData, Article article) {
        this.id = id;
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.imageData = imageData;
        this.article = article;
    }

    @ManyToOne
    @JoinColumn(name = "article_id")
    @JsonBackReference
    private Article article;

    public void setId(long id) {
        this.id = id;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public long getId() {
        return id;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public Article getArticle() {
        return article;
    }
}
