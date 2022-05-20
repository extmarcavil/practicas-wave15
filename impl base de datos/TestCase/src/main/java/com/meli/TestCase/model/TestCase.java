package com.meli.TestCase.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="description")
    private String desc;
    private boolean tested;
    private boolean passed;
    private int number_of_tries;
    private LocalDate lastUpdate;

    public TestCase(String description, boolean tested, boolean passed, int number_of_tries, LocalDate lastUpdate) {
        this.desc = description;
        this.tested = tested;
        this.passed = passed;
        this.number_of_tries = number_of_tries;
        this.lastUpdate = lastUpdate;
    }

    public TestCase(Long id, String description, boolean tested, boolean passed, int number_of_tries, LocalDate lastUpdate) {
        this.id = id;
        this.desc = description;
        this.tested = tested;
        this.passed = passed;
        this.number_of_tries = number_of_tries;
        this.lastUpdate = lastUpdate;
    }

    public TestCase(){}
}
