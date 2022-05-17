package com.meli.TestCase.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private LocalDate lastUpdate;

    public TestCase(String description, boolean tested, boolean passed, int number_of_tries, LocalDate lastUpdate) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.number_of_tries = number_of_tries;
        this.lastUpdate = lastUpdate;
    }

    public TestCase(Long id, String description, boolean tested, boolean passed, int number_of_tries, LocalDate lastUpdate) {
        this.id = id;
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.number_of_tries = number_of_tries;
        this.lastUpdate = lastUpdate;
    }

    public TestCase(){}
}
