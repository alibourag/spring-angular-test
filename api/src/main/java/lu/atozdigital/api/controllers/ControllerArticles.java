package lu.atozdigital.api.controllers;

import lu.atozdigital.api.DTO.ArticleDto;
import lu.atozdigital.api.services.ArticleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/articles")
public class ControllerArticles {

    private ArticleService articleService;

    public ControllerArticles(ArticleService articleService) {
        this.articleService = articleService;
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveArticle(@RequestParam("file") MultipartFile file,
                            @RequestParam("name") String name ,
                            @RequestParam("price") double price) throws IOException {
        articleService.saveArticle(name,price,file);
    }
}

/*
@RequestMapping(value = "/saveTaxitest", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveTaxiTest(@RequestParam("file") MultipartFile file,
                               @RequestParam("name") String name,
                               @RequestParam("tel") String tel,
                               @RequestParam("matricule") String matricule,
                               @RequestParam("ville") String ville) throws Exception {

        Taxi tax
Taxi taxi = new Taxi();
        Path path = Paths.get(System.getProperty("user.home")+"/animal_adoption/imagesCauffeurs/");
        try {
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        taxi.setNomChauffeur(name);
        taxi.setTel(tel);
        taxi.setMatricule(matricule);

 */