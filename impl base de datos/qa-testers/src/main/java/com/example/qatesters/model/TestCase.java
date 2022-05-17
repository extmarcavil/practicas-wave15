package com.example.qatesters.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "test_case")
@Data
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case", nullable = false)
    private Long idCase;

    @Column(name = "description")
    private String description;

    @Column(name = "tested")
    private Boolean tested;

    @Column(name = "passed")
    private Boolean passed;

    @Column(name = "number_of_tries")
    private Integer numberOfTries;

    @Column(name = "last_update")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDate lastUpdate;

}