package ma.fstt.repository;

import ma.fstt.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Categoryrepo extends JpaRepository<Categorie,Long> {
}
