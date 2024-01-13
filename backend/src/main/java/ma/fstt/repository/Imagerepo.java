package ma.fstt.repository;

import ma.fstt.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Imagerepo extends JpaRepository<Image,Long> {
    List<Image> findByArticleId(Long catalogueId);

    Image findByImageName(String imageName);
}
