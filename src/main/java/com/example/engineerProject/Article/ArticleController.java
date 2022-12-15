package com.example.engineerProject.Article;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * show new article form
     * @param model
     * @return
     */
    @GetMapping("/new-form")
    String newForm(Model model) {
        model.addAttribute("articleToSave", new ArticleDto());

        return "new-article-form";
    }

    /**
     * save new article
     * @param articleDto
     * @param bindingResult
     * @return
     */
    @PostMapping("/new-form/save")
    String saveForm(@Valid @ModelAttribute("articleToSave") ArticleDto articleDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "new-article-form";
        }
        articleService.saveArticle(articleDto);

        return "redirect:/new-form";
    }

    /**
     * show edit article form
     * @param articleId
     * @param model
     * @return
     */
    @GetMapping("/edit-form/{id}")
    String editArticle(@PathVariable("id") Long articleId, Model model) {
        if (articleService.takeArticleById(articleId).isEmpty()) {
            return "redirect:/all-user-articles";
        }

        ArticleDto articleDto = articleService.takeArticleById(articleId).get();
        model.addAttribute("editArticle", articleDto);

        return "edit-article-form";
    }

    /**
     * update article
     * @param articleDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(
            value = "/edit-form/update",
            method = {RequestMethod.PATCH, RequestMethod.POST}
    )
    String updateArticle(@Valid @ModelAttribute("editArticle") ArticleDto articleDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "edit-article-form";
        }

        articleService.updateArticle(articleDto);

        return "redirect:/all-user-articles";
    }

    /**
     * delete article
     * @param id id form
     * @return
     */
    @RequestMapping(
            value = "/all-user-articles/delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);

        return "redirect:/all-user-articles";
    }

    /**
     * show all current user article
     * @param model
     * @return
     */
    @GetMapping("/all-user-articles")
    String allUserArticles(Model model) {
        Set<ArticleDto> articleDtoSet = new HashSet<>();
        articleService.articlesByUser().ifPresent(articleDtoSet::addAll);

        model.addAttribute("articles", articleDtoSet);

        return "agent-articles-list";
    }

    /**
     * show single article
     * @param articleId
     * @param model
     * @return
     */
    @GetMapping("/article/{id}")
    String singleArticle(@PathVariable("id") Long articleId, Model model) {
        if (articleService.takeArticleById(articleId).isEmpty()) {
            return "approved-articles-list";
        }

        ArticleDto articleDto = articleService.takeArticleById(articleId).get();
        model.addAttribute("article", articleDto);

        return "single-article";
    }

    /**
     * show all approved articles
     * @param model
     * @return
     */
    @GetMapping("/all-approved")
    String allApprovedArticles(Model model) {
        Set<ArticleDto> articles = new HashSet<>();
        articleService.articlesByStatus(true).ifPresent(articles::addAll);

        model.addAttribute("articles", articles);

        return "approved-articles-list";
    }

    /**
     * show all unapproved articles
     * @param model
     * @return
     */
    @GetMapping("/all-unapproved")
    String allUnapprovedArticles(Model model) {
        Set<ArticleDto> articles = new HashSet<>();
        articleService.articlesByStatus(false).ifPresent(articles::addAll);

        model.addAttribute("articles", articles);

        return "unapproved-articles-list";
    }

    /**
     * approve a article
     * @param articleId
     * @return
     */
    @RequestMapping(
            value = "/all-unapproved-articles/approve/{id}",
            method = {RequestMethod.PATCH, RequestMethod.GET}
    )
    String approveArticle(@PathVariable("id") Long articleId){
        articleService.updateApproveStatus(articleId);

        return "redirect:/all-unapproved";
    }
}
