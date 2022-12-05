package com.example.engineerProject.Article;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    Set<Article> findAllByApprovedByManager(Boolean status);

    Set<Article> findAllByUser_Id(Long userId);
}
