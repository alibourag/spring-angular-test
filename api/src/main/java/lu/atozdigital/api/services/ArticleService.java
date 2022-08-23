package lu.atozdigital.api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lu.atozdigital.api.DTO.ArticleDto;
import lu.atozdigital.api.Repositories.ArticleRepository;
import lu.atozdigital.api.entities.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    }

    @Override
    public ArticleDto getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if(article.isPresent()){
            ArticleDto articleDto = new ArticleDto();
            articleDto.name = article.get().getName();
            articleDto.price = article.get().getPrice();
            articleDto.picture = article.get().getPicture();
            return articleDto;
        }
        return null;
    }

    @Override
    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
         List<ArticleDto> articleDtos = new ArrayList<>();
        articles.forEach(article -> {
            ArticleDto articleDto = new ArticleDto();
            articleDto.picture = article.getPicture();
            articleDto.name = article.getName();
            articleDto.price = article.getPrice();
            articleDtos.add(articleDto);
        });
        return articleDtos;
    }
}

