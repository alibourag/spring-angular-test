package lu.atozdigital.api.services;

import lu.atozdigital.api.DTO.ArticleDto;
import lu.atozdigital.api.entities.Article;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IArticleService {
    public void saveArticle(String name, double price ,MultipartFile picture) throws IOException;
}
