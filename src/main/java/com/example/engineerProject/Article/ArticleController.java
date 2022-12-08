package com.example.engineerProject.Article;

import com.example.engineerProject.User.AppUserService;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller("/article")
public class ArticleController {

    private final ArticleService articleService;
    private final AppUserService userService;

    public ArticleController(ArticleService articleService, AppUserService userService) {
        this.articleService = articleService;
        this.userService = userService;
    }

    @GetMapping("/new-form")
    String newForm(Model model) {
        model.addAttribute("article", new ArticleDto());

        return "article-form";
    }

    @PostMapping("/new-form/save")
    String saveForm(@ModelAttribute("article") ArticleDto articleDto) {
        articleService.saveArticle(articleDto);

        return "redirect:/new-form";
    }


    @GetMapping("/edit-form/{id}")
    String editArticle(@PathVariable("id") Long articleId, Model model) {
        if (articleService.takeArticleById(articleId).isEmpty()) {
            return "redirect:/all-user-articles";
        }

        ArticleDto articleDto = articleService.takeArticleById(articleId).get();
        model.addAttribute("article", articleDto);

        return "article-form";
    }

    @RequestMapping(
            value = "/edit-form/update",
            method = {RequestMethod.PATCH, RequestMethod.GET}
    )
    String updateArticle(@ModelAttribute("article") ArticleDto articleDto) {
        articleService.updateArticle(articleDto);

        return "redirect:/all-user-articles";
    }


    @PostMapping("/save-or-update")
    String saveOrUpdate(@Valid @ModelAttribute("article") ArticleDto articleDto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "article-form";
        }

        model.addAttribute("article", articleDto);
        if (articleDto.getId() == null) {
            return "redirect:/new-form/save";
        }

        return "redirect:/edit-form/update";
    }


    @RequestMapping(
            value = "/all-user-articles/delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);

        return "redirect:/all-user-articles";
    }

    @GetMapping("/all-user-articles")
    String allUserArticles(Model model) {
        Set<ArticleDto> articleDtoSet = new HashSet<>();
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Long currentUserId = userService.getUserIdByEmail(currentUserEmail);

        articleService.articlesByUser(currentUserId).ifPresent(articleDtoSet::addAll);

        model.addAttribute("articles", articleDtoSet);

        return "agent-articles-list";
    }

    @GetMapping("/all-approved-articles")
    String allApprovedArticles(Model model) {
        Set<ArticleDto> articles = new HashSet<>();
        articleService.articlesByStatus(true).ifPresent(articles::addAll);

        model.addAttribute("articles", articles);

        return "approved-articles-list";
    }

    @GetMapping("/all-unapproved-articles")
    String allUnapprovedArticles(Model model) {
        Set<ArticleDto> articles = new HashSet<>();
        articleService.articlesByStatus(false).ifPresent(articles::addAll);

        model.addAttribute("articles", articles);

        return "unapproved-articles-list";
    }

    @RequestMapping(
            value = "/all-unapproved-articles/approve/{id}",
            method = {RequestMethod.PATCH, RequestMethod.GET}
    )
    String approveArticle(@PathVariable("id") Long articleId){
        articleService.updateApproveStatus(articleId);

        return "redirect:/all-unapproved-articles";
    }
}
