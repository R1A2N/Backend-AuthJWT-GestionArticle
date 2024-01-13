package ma.fstt.service;


import ma.fstt.entity.Article;
import ma.fstt.entity.Image;
import ma.fstt.exeption.CatalogueNotFoundException;
import ma.fstt.repository.Articlerepo;
import ma.fstt.repository.Imagerepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class Imagesrvc {

    @Resource
    private Imagerepo imgrepo;
    private Articlerepo cataloguerepo;
    public String uploadImageToCatalog(long catalogId, MultipartFile file) throws CatalogueNotFoundException {
        Article catalogue = cataloguerepo.findById(catalogId)
                .orElseThrow(() -> new CatalogueNotFoundException("Article not found with ID: " + catalogId));

        try {
            byte[] imageData = file.getBytes();

            // Récupère le nom original du fichier
            String imageName = file.getOriginalFilename();

            // Sauvegarde l'image dans la base de données en associant l'ID du catalogue
            Image image = new Image();
            image.setImageName(imageName);
            image.setArticle(catalogue);
            imgrepo.save(image);

            // Choisissez le répertoire où vous souhaitez enregistrer les images dans votre projet
            String uploadDirectory = ".\\..\\Code-source\\src\\imagess"; // Mettez le chemin correct ici

            // Générez le chemin complet du fichier
            Path imagePath = Paths.get(uploadDirectory, imageName);

            // Copiez les données de l'image dans le fichier sur le système de fichiers
            Files.write(imagePath, imageData);

            // Vous pouvez retourner le chemin complet de l'image ou simplement le nom
            return imagePath.toString();
        } catch (IOException e) {
            // Gérez l'exception de manière appropriée (par exemple, en la journalisant ou en lançant une exception personnalisée)
            throw new RuntimeException("Failed to upload image", e);
        }
    }


    private final String imageFolderPath = ".\\..\\Code-source\\src\\imagess";


}
