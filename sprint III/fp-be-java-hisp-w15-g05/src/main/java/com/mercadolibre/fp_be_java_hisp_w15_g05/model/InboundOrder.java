package com.mercadolibre.fp_be_java_hisp_w15_g05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class InboundOrder {

    @Id
    private Integer order_number;

    private LocalDate order_date;
    private Integer section_id;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "inbound_order_batch",
            joinColumns = @JoinColumn(name = "inbound_order_id"),
            inverseJoinColumns = @JoinColumn(name = "batch_id"))
    private List<Batch> batch_stock;
}
