package com.example.engineerProject.Article;

public class ArticleMapper {
    static ArticleDto map(Article article) {
        return new ArticleDto(
                article.getId(),
                article.getTitle(),
                article.getPicture(),
                article.getDescription(),
                article.getDate(),
                article.getApprovedByManager(),
                article.getUser()
        );
    }

    static Article map(ArticleDto articleDto) {
        Article article = new Article(
                articleDto.getId(),
                articleDto.getTitle(),
                articleDto.getPicture(),
                articleDto.getDescription(),
                articleDto.getDate()
        );

        article.setApprovedByManager(articleDto.getApprovedByManager());
        article.setUser(articleDto.getUser());

        return article;
    }
}
