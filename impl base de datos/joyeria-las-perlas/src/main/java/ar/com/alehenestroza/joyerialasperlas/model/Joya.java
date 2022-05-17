package ar.com.alehenestroza.joyerialasperlas.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String material;
    private Double weight;
    private String uniqueQuality;
    private Boolean hasStone;
    private Boolean isAvailable;
}
