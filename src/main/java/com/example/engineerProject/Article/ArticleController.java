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
    String saveForm(@Valid @ModelAttribute("article") ArticleDto articleDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "article-form";
        }

        articleService.saveArticle(articleDto);

        return "redirect:/new-form";
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
    String allUsersArticles(Model model) {
        Set<ArticleDto> articleDtoSet = new HashSet<>();
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Long currentUserId = userService.getUserIdByEmail(currentUserEmail);

        articleService.articlesByUser(currentUserId).ifPresent(articleDtoSet::addAll);

        model.addAttribute("articles", articleDtoSet);

        return "agent-articles";
    }

    @GetMapping("/all-unapproved-articles")
    String allUnapprovedArticles(Model model) {
        Set<ArticleDto> articles = new HashSet<>();
        articleService.articlesByStatus(false).ifPresent(articles::addAll);

        model.addAttribute("articles", articles);

        return "unapproved-articles";
    }

    @RequestMapping(
            value = "/all-unapproved-articles/approve",
            method = {RequestMethod.PATCH, RequestMethod.GET}
    )
    String approveArticle(@RequestParam("ArticleId") Long articleId){
        articleService.updateApproveStatus(articleId);

        return "redirect:/all-unapproved-articles";
    }
}
