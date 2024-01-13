package ma.fstt.controller;


import ma.fstt.entity.Categorie;
import ma.fstt.service.Categoriservc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Resource
    private Categoriservc catsrv;


    @PostMapping("/add")
    public ResponseEntity<Categorie> addCatalogue(@RequestBody Categorie c){

        return new ResponseEntity<>(catsrv.ajouter_catalogue(c), HttpStatus.OK);
    }

    @GetMapping("/all")

    public  ResponseEntity<List<Categorie>> findall(){
        return new ResponseEntity<>(catsrv.getlist(), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getImageById(@PathVariable Long id) {
        Categorie imageEntity = catsrv.getCatalqueById(id);

        if (imageEntity != null) {
            return ResponseEntity.ok(imageEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable long id){
        catsrv.deletecatal(id);

    }
}
