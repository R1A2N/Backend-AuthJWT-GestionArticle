package ma.fstt.controller;


import ma.fstt.entity.Article;

import ma.fstt.service.ArticleService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;


    @GetMapping("/byCatalogue/{catalogueId}")
    public List<Article> getArticlesByCatalogueId(@PathVariable Long catalogueId) {
        return articleService.getArticlesByCatalogueId(catalogueId);
    }

    @PostMapping("/create/{catalogueId}")
    public Article createArticleByCatalogueId(@RequestBody Article article, @PathVariable Long catalogueId) {
        return articleService.createArticleByCatalogueId(article, catalogueId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArticle(@PathVariable long id) {
        articleService.deleteArticle(id);
    }
}
