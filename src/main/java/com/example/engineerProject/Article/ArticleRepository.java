package com.example.engineerProject.Article;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    Set<Article> findAllByApprovedByManager(@Param("approvedByManager") Boolean status);

    Set<Article> findAllByUser_Id(Long userId);
}
