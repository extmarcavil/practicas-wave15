package com.mercadolibre.fp_be_java_hisp_w15_g05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer section_id;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = "section_type_id")
    SectionType type;

    private int total_size;
    private int current_size;


    @OneToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE
            },
            mappedBy = "section")
    private List<Batch> batchList;



}
