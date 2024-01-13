package ma.fstt.service;

import ma.fstt.entity.Categorie;
import ma.fstt.repository.Categoryrepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Categoriservc {

    @Resource
    private Categoryrepo categoryrepo;

    //ajouter catalogue
    public Categorie ajouter_catalogue(Categorie ctlg){
        return categoryrepo.save(ctlg);

    }
    //get la list des catalogue
    public List<Categorie> getlist(){
        return  categoryrepo.findAll();

    }

    //delete catalogue
    public void deletecatal(long id){
        categoryrepo.deleteById(id);

    }
    public Categorie getCatalqueById(Long id) {
        return categoryrepo.findById(id).orElse(null);
    }

}
