package com.webatrio.backend.controllers;

import com.webatrio.backend.controllers.reponses.IPersonFormatted;
import com.webatrio.backend.controllers.reponses.SuccessResponse;
import com.webatrio.backend.entities.Experience;
import com.webatrio.backend.entities.Person;
import com.webatrio.backend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@RestController
@CrossOrigin
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<IPersonFormatted>> getPersons() {
        Set<Person> persons = new TreeSet<>(personRepository.findAll());

        List<IPersonFormatted> personsList = persons.stream()
                .map(person -> {
                    Optional<Experience> currentEx = person.getExperiences()
                            .stream()
                            .filter(ex -> ex.getEndDate() == null)
                            .findFirst();

                    return new IPersonFormatted(
                            person.getId(),
                            person.getFirstName(),
                            person.getLastName(),
                            Math.abs(ChronoUnit.YEARS.between(LocalDate.now(), person.getBirthDate())),
                            currentEx.isPresent() ? currentEx.get().getCompany().getName() : "Not Employed");
                })
                .toList();

        return new ResponseEntity<>(personsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> createPerson(@RequestBody Person person) {
        if (Math.abs(ChronoUnit.YEARS.between(LocalDate.now(), person.getBirthDate())) > 150) {
            throw new RuntimeException("Age is out of boundaries");
        }

        personRepository.save(person);

        return new ResponseEntity<>(new SuccessResponse(), HttpStatus.OK);
    }
}
