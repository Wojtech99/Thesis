package com.example.engineerProject.Article;

import com.example.engineerProject.Data.ImageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

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
            if (!Objects.requireNonNull(imageFile.getOriginalFilename()).endsWith(".jpg") &&
                    !Objects.requireNonNull(imageFile.getOriginalFilename()).endsWith(".JPG") &&
                    !Objects.requireNonNull(imageFile.getOriginalFilename()).endsWith(".png")) {
                returnSite = "new-article-form";
                return returnSite;
            }

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
        Optional<ArticleDto> optionalArticleDto = articleService.takeArticleById(articleId);

        String returnSite = "edit-article-form";

        if (optionalArticleDto.isEmpty()) {
            returnSite = "redirect:/all-user-articles";
            return returnSite;
        }

        ArticleDto articleDto = optionalArticleDto.get();
        model.addAttribute("editArticle", articleDto);

        return returnSite;
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
                         @RequestParam("image") MultipartFile imageFile,
                         BindingResult bindingResult) {
        String returnSite = "redirect:/all-user-articles";

        if (bindingResult.hasErrors()){
            returnSite = "edit-article-form";
            return returnSite;
        }

        if (imageFile != null) {
            if (!Objects.requireNonNull(imageFile.getOriginalFilename()).endsWith(".jpg") &&
                    !Objects.requireNonNull(imageFile.getOriginalFilename()).endsWith(".JPG") &&
                    !Objects.requireNonNull(imageFile.getOriginalFilename()).endsWith(".png")) {
                returnSite = "new-article-form";
                return returnSite;
            }

            try {
                imageService.deleteData(articleDto.getPicture());

                String imagePath = imageService.saveData(imageFile);
                articleDto.setPicture(imagePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        articleService.updateArticle(articleDto);

        return returnSite;
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
            Optional<ArticleDto> optionalArticleDto = articleService.takeArticleById(id);

            if (optionalArticleDto.isPresent()) {
                ArticleDto articleDto = optionalArticleDto.get();

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
        String returnSite = "single-article";

        Optional<ArticleDto> optionalArticleDto = articleService.takeArticleById(articleId);

        if (optionalArticleDto.isEmpty()) {
            returnSite = "redirect:/all-approved";
            return returnSite;
        }

        ArticleDto articleDto = optionalArticleDto.get();
        model.addAttribute("article", articleDto);

        return returnSite;
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
