package ma.fstt.controller;


import ma.fstt.exeption.CatalogueNotFoundException;
import ma.fstt.service.Imagesrvc;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/app/image")
public class ImageController {

    @Resource
    private Imagesrvc imageservice;

    @PostMapping("/upload/{articleId}")
    public ResponseEntity<String> uploadImageToCatalog(
            @PathVariable Long catalogueId,
            @RequestParam("file") MultipartFile file) throws CatalogueNotFoundException {

        imageservice.uploadImageToCatalog(catalogueId, file);
        return ResponseEntity.ok("Image uploaded successfully.");
    }
}
