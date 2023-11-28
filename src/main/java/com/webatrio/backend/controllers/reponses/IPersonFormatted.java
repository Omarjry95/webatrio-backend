package com.webatrio.backend.controllers.reponses;

import java.util.Objects;

public class IPersonFormatted {

    private Long id;

    private String firstName;

    private String lastName;

    private Long age;

    private String currentEx;

    public IPersonFormatted(Long id, String firstName, String lastName, Long age, String currentEx) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.currentEx = currentEx;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getCurrentEx() {
        return currentEx;
    }

    public void setCurrentEx(String currentEx) {
        this.currentEx = currentEx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IPersonFormatted that = (IPersonFormatted) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
