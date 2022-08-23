package lu.atozdigital.api.Repositories;

import lu.atozdigital.api.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
