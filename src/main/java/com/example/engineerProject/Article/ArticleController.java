package com.example.engineerProject.Article;

import com.example.engineerProject.Data.ImageService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final ImageService imageService;

    public ArticleController(ArticleService articleService, ImageService imageService) {
        this.articleService = articleService;
        this.imageService = imageService;
    }

    /**
     * show new article form
     * @param model Model
     * @return String
     */
    @GetMapping("/new-form")
    String newForm(Model model) {
        model.addAttribute("articleToSave", new ArticleDto());

        return "new-article-form";
    }

    /**
     * save new article
     * @param articleDto ArticleDto
     * @param bindingResult BindingResult
     * @param imageFile MultipartFile
     * @return String
     */
    @PostMapping("/new-form/save")
    String saveForm(@Valid @ModelAttribute("articleToSave") ArticleDto articleDto,
                    BindingResult bindingResult,
                    @RequestParam("image") MultipartFile imageFile) {

        String returnSite = "redirect:/new-form";

        if (bindingResult.hasErrors()){
            returnSite = "new-article-form";
            return returnSite;
        }

        try{
            String imagePath = imageService.saveData(imageFile);
            articleDto.setPicture(imagePath);
            articleService.saveArticle(articleDto);
        } catch (IOException e) {
            throw new NoSuchElementException(e);
        }


        return returnSite;
    }

    /**
     * show edit article form
     * @param articleId Long
     * @param model Model
     * @return String
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
     * @param articleDto ArticleDto
     * @param bindingResult BindingResult
     * @return String
     */
    @RequestMapping(
            value = "/edit-form/update",
            method = {RequestMethod.PATCH, RequestMethod.POST}
    )
    String updateArticle(@Valid @ModelAttribute("editArticle") ArticleDto articleDto,
                         @Param("image") MultipartFile imageFile,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "edit-article-form";
        }

        if (imageFile != null) {
            try {
                imageService.deleteData(articleDto.getPicture());

                String imagePath = imageService.saveData(imageFile);
                articleDto.setPicture(imagePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        articleService.updateArticle(articleDto);

        return "redirect:/all-user-articles";
    }

    /**
     * delete article
     * @param id Long
     * @return String
     */
    @RequestMapping(
            value = "/all-user-articles/delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteArticle(@PathVariable("id") Long id) {
        try {
            if (articleService.takeArticleById(id).isPresent()) {
                ArticleDto articleDto = articleService.takeArticleById(id).get();

                imageService.deleteData(articleDto.getPicture());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        articleService.deleteArticle(id);

        return "redirect:/all-user-articles";
    }

    /**
     * show all current user article
     * @param model Model
     * @return String
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
     * @param articleId Long
     * @param model Model
     * @return String
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
     * @param model Model
     * @return String
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
     * @param model Model
     * @return String
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
     * @param articleId Long
     * @return String
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
