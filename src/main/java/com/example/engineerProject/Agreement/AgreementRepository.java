package com.example.engineerProject.Agreement;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AgreementRepository extends CrudRepository<Agreement, Long> {
    Set<Agreement> findAll();

    Agreement getAgreementById(Long id);
}
