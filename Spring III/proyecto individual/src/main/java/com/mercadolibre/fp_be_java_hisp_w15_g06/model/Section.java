package com.mercadolibre.fp_be_java_hisp_w15_g06.model;

import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sections")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Section {

    //ToDo: Estaria bueno que el name como tiene que ser un nombre concreto seria bueno que sea un ENUM
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer maxQuantityBatch;

    private Double minimumTemperature;

    private Double maximumTemperature;

    @OneToMany
   // @JoinColumn(name = "section_id")
    private List<Batch> listBatch;
}
