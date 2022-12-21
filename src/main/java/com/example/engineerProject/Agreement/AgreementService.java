package com.example.engineerProject.Agreement;

import com.example.engineerProject.User.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class AgreementService {

    private final AgreementRepository agreementRepository;

    public AgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    @Transactional
    void saveAgreement(MultipartFile multipartFile) throws IOException {
        AgreementDto agreementDto = new AgreementDto();
        Date date = new Date(System.currentTimeMillis());

        agreementDto.setName(multipartFile.getOriginalFilename());
        agreementDto.setType(multipartFile.getContentType());
        agreementDto.setUploadDate(date);
        agreementDto.setBytes(multipartFile.getBytes());


        Agreement agreementToSave = AgreementMapper.map(agreementDto);

        agreementRepository.save(agreementToSave);
    }

    @Transactional
    void deleteAgreement(Long agreementId) {
        if (isCurrentUserManager()) {
            agreementRepository.deleteById(agreementId);
        }
    }

    private boolean isCurrentUserManager() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_" + Role.MANAGER.getDescription()));
    }

    AgreementDto getAgreement(Long agreementId) {
        return AgreementMapper.map(agreementRepository.getAgreementById(agreementId));
    }

    Set<AgreementDto> showAllAgreements() {
        return agreementRepository.findAll().stream()
                .map(AgreementMapper::map)
                .collect(Collectors.toSet());
    }
}
