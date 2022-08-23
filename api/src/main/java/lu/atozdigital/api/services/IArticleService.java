package lu.atozdigital.api.services;

import lu.atozdigital.api.DTO.ArticleDto;
import lu.atozdigital.api.entities.Article;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IArticleService {
    public void saveArticle(String name, double price ,MultipartFile picture) throws IOException;
    public ArticleDto getArticle(Long id);
    public List<ArticleDto> getAllArticles();
}
