package lu.atozdigital.api.controllers;

import lu.atozdigital.api.DTO.ArticleDto;
import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.services.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticle(@PathVariable("id") Long id){
        ArticleDto articleDto = articleService.getArticle(id);
        if(articleDto==null){
            return new ResponseEntity<>("Article Not Found !!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(articleDto, HttpStatus.OK);
    }
    @GetMapping
    public List<ArticleDto> getAllArticles(){
        return articleService.getAllArticles();
    }
}