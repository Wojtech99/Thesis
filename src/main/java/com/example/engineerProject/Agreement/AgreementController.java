package com.example.engineerProject.Agreement;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;

@Controller
public class AgreementController {

    private final AgreementService agreementService;

    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    /**
     * show new agreement form
     * @return String
     */
    @GetMapping("/add-agreement")
    String addAgreementPage() {
        return "new-agreement-form";
    }

    /**
     * save new pdf agreement
     * @param multipartFile MultipartFile
     * @return String
     */
    @PostMapping("/add-agreement/save")
    String saveAgreement(@RequestParam("pdfFile") MultipartFile multipartFile) {

        try {
            agreementService.saveAgreement(multipartFile);
        } catch (IOException exception) {
            throw new NoSuchElementException();
        }

        return "redirect:/show-agreements";
    }

    /**
     * show all agreements
     * @param model Model
     * @return String
     */
    @GetMapping("/show-agreements")
    String showAllAgreements(Model model) {
        Set<AgreementDto> agreements = agreementService.showAllAgreements();

        model.addAttribute("agreements", agreements);

        return "agreements-list";
    }

    /**
     * delete agreement
     * @param agreementId Long
     * @return String
     */
    @RequestMapping(
            value = "/show-agreements/delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteAgreement(@PathVariable("id") Long agreementId) {
        agreementService.deleteAgreement(agreementId);
        return"redirect:/show-agreements";
    }

    @GetMapping("/show-agreements/download/{id}")
    ResponseEntity<ByteArrayResource> downloadAgreement(@PathVariable("id") Long agreementId) {
        AgreementDto agreementDto = agreementService.getAgreement(agreementId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(agreementDto.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""
                        + agreementDto.getName() + "\"")
                .body(new ByteArrayResource(agreementDto.getBytes()));
    }
}
