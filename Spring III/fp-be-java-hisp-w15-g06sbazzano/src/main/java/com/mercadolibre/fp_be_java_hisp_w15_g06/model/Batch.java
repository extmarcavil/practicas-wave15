package com.mercadolibre.fp_be_java_hisp_w15_g06.model;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.BatchStockDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "batches")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double minimumTemperature;

    private Double currentTemperature;

    private Integer initialQuantity;

    private Integer currentQuantity;

    private LocalDateTime manufacturingTime;

    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="section_id", nullable=false)
    private Section section;


    @ManyToOne
    private Product product;

    @OneToOne
    private InboundOrder inboundOrder;

    public Batch(BatchStockDTO batchStockDTO, Product product){

        this.minimumTemperature = batchStockDTO.getMinimumTemperature();
        this.currentTemperature = batchStockDTO.getCurrentTemperature();
        this.initialQuantity = batchStockDTO.getInitialQuantity();
        this.currentQuantity = batchStockDTO.getCurrentQuantity();
        this.manufacturingTime = batchStockDTO.getManufacturingTime();
        this.dueDate = batchStockDTO.getDueDate();
        this.product = product;

    }
}
