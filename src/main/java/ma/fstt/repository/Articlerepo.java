package ma.fstt.repository;

import ma.fstt.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Articlerepo  extends JpaRepository<Article,Long> {
    List<Article> findByCategorieId(Long categorieId);
}
