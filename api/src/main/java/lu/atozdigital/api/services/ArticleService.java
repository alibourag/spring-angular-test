package lu.atozdigital.api.services;

import lu.atozdigital.api.DTO.ArticleDto;
import lu.atozdigital.api.Repositories.ArticleRepository;
import lu.atozdigital.api.entities.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ArticleService implements IArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void saveArticle(String name, double price , MultipartFile picture) throws IOException {
        byte[] pic = picture.getBytes();
        Article article = new Article();
        article.setPicture(pic);
        article.setName(name);
        article.setPrice(price);
        articleRepository.save(article);
        //System.out.println();
    }
}

