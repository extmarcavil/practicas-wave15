package ar.com.alehenestroza.miniseries.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MINISERIES")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Double rating;
    private Integer amountOfAwards;
}
