package com.mercadolibre.fp_be_java_hisp_w15_g05.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Batch {

    @Id
    private Integer batch_number;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST
            })
    @JoinColumn(name="section_id", referencedColumnName = "section_id", nullable = false)
    private Section section;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST
            })
    @JoinColumn(name="product_id",  referencedColumnName = "product_id", nullable = false)
    private Product product;

    @ManyToMany(mappedBy = "batch_stock", fetch = FetchType.LAZY)
    private List<InboundOrder> inboundOrderList;

    private LocalDate due_date;
    private int initial_quantity;
    private int current_quantity;
    private LocalDateTime manufacturing_date;
    private LocalDateTime manufacturing_time;
    private double minimum_temperature;
    private double current_temperature;
}
