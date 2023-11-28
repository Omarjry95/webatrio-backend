package com.webatrio.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Experience implements Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name="person", nullable=false)
    private Person person;

    @ManyToOne
    @JoinColumn(name="company", nullable=false)
    private Company company;

    public Experience(LocalDate startDate, LocalDate endDate, Person person, Company company) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.person = person;
        this.company = company;
    }

    public Experience() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int compareTo(Object o) {
        Experience experience = (Experience) o;

        return startDate.compareTo(experience.getStartDate());
    }
}
