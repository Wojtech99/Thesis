package com.example.engineerProject.Agreement;

public class AgreementMapper {
    static AgreementDto map(Agreement agreement) {
        return new AgreementDto(
                agreement.getId(),
                agreement.getName(),
                agreement.getType(),
                agreement.getUploadDate(),
                agreement.getBytes()
        );
    }

    static Agreement map(AgreementDto agreementDto) {
        return new Agreement(
                agreementDto.getId(),
                agreementDto.getName(),
                agreementDto.getType(),
                agreementDto.getUploadDate(),
                agreementDto.getBytes()
        );
    }
}
