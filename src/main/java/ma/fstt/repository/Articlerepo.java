package ma.fstt.repository;

import ma.fstt.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Articlerepo  extends JpaRepository<Article,Long> {
}
