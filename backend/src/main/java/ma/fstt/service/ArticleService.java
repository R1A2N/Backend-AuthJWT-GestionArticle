package ma.fstt.service;

import ma.fstt.entity.Article;
import ma.fstt.entity.Categorie;
import ma.fstt.repository.Articlerepo;
import ma.fstt.repository.Categoryrepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ArticleService {
    @Resource
    private Articlerepo articlerepo;


    public List<Article> getArticlesByCatalogueId(Long catalogueId) {
        return articlerepo.findByCategorieId(catalogueId);
    }

    public void deleteArticle(long id) {
        articlerepo.deleteById(id);
    }

    public Article createArticleByCatalogueId(Article article, Long catalogueId) {
        Categorie catalogue = new Categorie();
        catalogue.setId(catalogueId);
        article.setCategorie(catalogue);
        return articlerepo.save(article);
    }

}
