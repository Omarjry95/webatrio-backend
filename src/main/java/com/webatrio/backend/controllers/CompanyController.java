package com.webatrio.backend.controllers;

import com.webatrio.backend.entities.Company;
import com.webatrio.backend.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.TreeSet;

@RestController
@CrossOrigin
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public ResponseEntity<Set<Company>> getCompanies() {
        Set<Company> companies = new TreeSet<>(companyRepository.findAll());

        return new ResponseEntity<>(companies, HttpStatus.OK);
    }
}
