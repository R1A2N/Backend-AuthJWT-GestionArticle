package ma.fstt.service;

import ma.fstt.entity.Article;
import ma.fstt.entity.Categorie;
import ma.fstt.repository.Articlerepo;
import ma.fstt.repository.Categoryrepo;

import javax.annotation.Resource;
import java.util.List;

public class ArticleService {
    @Resource
    private Articlerepo categoryrepo;

    //ajouter catalogue
    public Article ajouter_catalogue(Article ctlg){
        return categoryrepo.save(ctlg);

    }
    //get la list des catalogue
    public List<Article> getlist(){
        return  categoryrepo.findAll();

    }

    //delete catalogue
    public void deletecatal(long id){
        categoryrepo.deleteById(id);

    }
    public Article getCatalqueById(Long id) {
        return categoryrepo.findById(id).orElse(null);
    }

}
