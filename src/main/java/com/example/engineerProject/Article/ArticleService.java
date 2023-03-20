package com.example.engineerProject.Article;

import com.example.engineerProject.User.AppUser;
import com.example.engineerProject.User.AppUserService;
import com.example.engineerProject.User.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final AppUserService userService;

    public ArticleService(ArticleRepository articleRepository, AppUserService userService) {
        this.articleRepository = articleRepository;
        this.userService = userService;
    }

    @Transactional
    ArticleDto saveArticle(ArticleDto articleDto) {
        Date date = new Date(System.currentTimeMillis());
        AppUser appUser = userService.getCurrentUserToSave();

        articleDto.setDate(date);
        articleDto.setUser(appUser);

        articleDto.setApprovedByManager(appUser.getRole().getDescription().equals(Role.MANAGER.getDescription()));

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
        Optional<Article> optionalArticle = articleRepository.findById(articleDto.getId());

        if(optionalArticle.isEmpty()) {
            return Optional.empty();
        }

        AppUser appUser = userService.getCurrentUserToSave();
        articleDto.setApprovedByManager(appUser.getRole().getDescription().equals(Role.MANAGER.getDescription()));


        Article article = optionalArticle.get();
        Article articleToUpdate = setEntityFields(article, articleDto);
        Article savedArticle = articleRepository.save(articleToUpdate);

        return Optional.of(ArticleMapper.map(savedArticle));
    }

    private Article setEntityFields(Article article, ArticleDto articleDto){
        if (!articleDto.getTitle().isEmpty()){
            article.setTitle(articleDto.getTitle());
        }

        if (articleDto.getPicture() != null){
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

    Optional<Set<ArticleDto>> articlesByUser(){
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Long currentUserId = userService.getUserIdByEmail(currentUserEmail);


        return Optional.of(articleRepository.findAllByUser_Id(currentUserId).stream()
                .map(ArticleMapper::map)
                .collect(Collectors.toSet()));
    }

    Optional<ArticleDto> takeArticleById(Long id) {
        Optional<Article> optionalArticleDto = articleRepository.findById(id);

        if (optionalArticleDto.isEmpty()) {
            return Optional.empty();
        }
        Article article = optionalArticleDto.get();

        return Optional.of(ArticleMapper.map(article));
    }
}
