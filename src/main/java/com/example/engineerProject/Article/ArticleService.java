package com.example.engineerProject.Article;

import com.example.engineerProject.User.Dto.AppUserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    ArticleDto saveArticle(ArticleDto articleDto) {
        Article articleToSave = ArticleMapper.map(articleDto);
        Article savedArticle = articleRepository.save(articleToSave);

        return ArticleMapper.map(savedArticle);
    }

    @Transactional
    void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }

    @Transactional
    Optional<ArticleDto> updateApproveStatus(Long articleId){
        if (articleRepository.findById(articleId).isEmpty()) {
            return Optional.empty();
        }

        Article articleToSave = articleRepository.findById(articleId).get();

        articleToSave.setApprovedByManager(!articleToSave.getApprovedByManager());

        Article savedArticle = articleRepository.save(articleToSave);

        return Optional.of(ArticleMapper.map(savedArticle));
    }

    @Transactional
    Optional<ArticleDto> updateArticle(ArticleDto articleDto) {
        if(articleRepository.findById(articleDto.getId()).isEmpty()) {
            return Optional.empty();
        }

        Article article = articleRepository.findById(articleDto.getId()).get();
        Article articleToUpdate = setEntityFields(article, articleDto);
        Article savedArticle = articleRepository.save(articleToUpdate);

        return Optional.of(ArticleMapper.map(savedArticle));
    }

    Article setEntityFields(Article article, ArticleDto articleDto){
        if (!articleDto.getTitle().isEmpty()){
            article.setTitle(articleDto.getTitle());
        }

        if (!articleDto.getPicture().isEmpty()) {
            article.setPicture(articleDto.getPicture());
        }

        if (!articleDto.getDescription().isEmpty()) {
            article.setDescription(articleDto.getDescription());
        }

        return article;
    }

    Optional<Set<ArticleDto>> articlesByStatus(boolean status){
        return Optional.of(articleRepository.findAllByApprovedByManager(status).stream()
                .map(ArticleMapper::map)
                .collect(Collectors.toSet()));
    }

    Optional<Set<ArticleDto>> articlesByUser(Long appUserId){
        return Optional.of(articleRepository.findAllByUser_Id(appUserId).stream()
                .map(ArticleMapper::map)
                .collect(Collectors.toSet()));
    }

    Optional<ArticleDto> takeArticleById(Long id) {
        if (articleRepository.findById(id).isEmpty()) {
            return Optional.empty();
        }
        Article article = articleRepository.findById(id).get();

        return Optional.of(ArticleMapper.map(article));
    }
}
