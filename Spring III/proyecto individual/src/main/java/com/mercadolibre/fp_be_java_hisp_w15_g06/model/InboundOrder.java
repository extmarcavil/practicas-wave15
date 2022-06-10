package com.mercadolibre.fp_be_java_hisp_w15_g06.model;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.InboundOrderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "inbound_orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class InboundOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;

    @OneToOne
    private Warehouse warehouse;

    @OneToOne
    private Section section;

    @OneToOne
    private Agent agent;


    public InboundOrder(InboundOrderDTO inboundOrderDTO, Warehouse warehouse, Section section, Agent agent){
        this.orderDate = inboundOrderDTO.getOrder_date();
        this.warehouse = warehouse;
        this.section = section;
        this.agent = agent;

    }

    public InboundOrder(Long id){
        this.id = id;
    }
}
