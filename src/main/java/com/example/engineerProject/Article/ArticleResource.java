package com.example.engineerProject.Article;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController("/resource-article")
public class ArticleResource {
    private final ArticleService articleService;

    public ArticleResource(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    ResponseEntity<ArticleDto> getArticle(@PathVariable Long id){
        return articleService.takeArticleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    ResponseEntity<ArticleDto> saveArticle(@Valid @RequestBody ArticleDto articleDto) {
        ArticleDto savedArticle = articleService.saveArticle(articleDto);
        URI savedArticleUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedArticle.getId())
                .toUri();

        return ResponseEntity.created(savedArticleUri).body(savedArticle);
    }

    @PatchMapping("/update")
    ResponseEntity<?> updateArticle(@Valid @RequestBody ArticleDto articleDto) {
        return articleService.updateArticle(articleDto)
                .map(article -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/id")
    ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all-user-articles/{id}")
    ResponseEntity<Set<ArticleDto>> allUserArticles(@PathVariable("id") Long userId){
        return articleService.articlesByUser(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all-approved-articles")
    ResponseEntity<Set<ArticleDto>> allApprovedArticles() {
        return articleService.articlesByStatus(true)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all-unapproved-articles")
    ResponseEntity<Set<ArticleDto>> allUnapprovedArticles() {
        return articleService.articlesByStatus(false)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/approve/{id}")
    ResponseEntity<?> updateArticleStatus(@PathVariable("id") Long articleId){
        return articleService.updateApproveStatus(articleId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }
}
