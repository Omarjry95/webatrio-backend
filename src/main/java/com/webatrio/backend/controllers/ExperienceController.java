package com.webatrio.backend.controllers;

import com.webatrio.backend.controllers.reponses.SuccessResponse;
import com.webatrio.backend.controllers.requests.IExperienceBody;
import com.webatrio.backend.entities.Company;
import com.webatrio.backend.entities.Experience;
import com.webatrio.backend.entities.Person;
import com.webatrio.backend.repositories.CompanyRepository;
import com.webatrio.backend.repositories.ExperienceRepository;
import com.webatrio.backend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/experiences")
public class ExperienceController {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping
    public ResponseEntity<SuccessResponse> createExperience(@RequestBody IExperienceBody experience) {
        Person person = personRepository.findById(Long.valueOf(experience.getPerson()))
                .orElseThrow(() -> new RuntimeException("Person not found !"));

        Company company = companyRepository.findById(Long.valueOf(experience.getCompany()))
                        .orElseThrow(() -> new RuntimeException("Company not found"));

        experienceRepository.save(new Experience(experience.getStartDate(), experience.getEndDate(), person, company));

        return new ResponseEntity<>(new SuccessResponse(), HttpStatus.OK);
    }
}
