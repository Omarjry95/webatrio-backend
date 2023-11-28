package com.webatrio.backend.utils;

import com.webatrio.backend.entities.Company;
import com.webatrio.backend.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CompanyRepository companyRepository;

    @Autowired
    public DataInitializer(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Company company1 = new Company("Webatrio Toulouse");

        Company company2 = new Company("Webatrio Paris");

//        companyRepository.saveAll(List.of(company1, company2));
    }
}
