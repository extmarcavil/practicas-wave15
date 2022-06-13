package com.mercadolibre.fp_be_java_hisp_w15_g05.utils;

import com.mercadolibre.fp_be_java_hisp_w15_g05.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SectionFactory {

    public static Section getSectionWithId1() {
        Warehouse warehouse = new Warehouse(1, "Centro de distribución 1");
        SectionType sectionType = new SectionType(1L, SectionTypeE.FRESH);

        Product product = new Product();
        product.setProduct_id(3);
        product.setName("manzana");

        InboundOrder inboundOrder = new InboundOrder(1, LocalDate.of(2022, 04, 01), 1 , null);

        Section section = new Section(1, warehouse, sectionType, 20, 15, null);
        Batch batch = new Batch(1, section, product, List.of(inboundOrder), LocalDate.of(2022, 5, 1), 20, 12, LocalDateTime.of(2022,04,01, 00, 00, 00), LocalDateTime.of(2022,04,01, 00, 00, 00), 10, 12);

        section.setBatchList(List.of(batch));
        inboundOrder.setBatch_stock(List.of(batch));
        product.setBatchList(List.of(batch));

        return section;
    }

    public static Section getSectionWithId2() {
        Section section = new Section();
        section.setSection_id(2);
        section.setType(new SectionType(2L, SectionTypeE.FROZEN));
        section.setCurrent_size(20);

        return section;
    }

    public static Section getSectionWithId3() {
        Section section = new Section();
        section.setSection_id(2);
        section.setCurrent_size(20);

        return section;
    }
}
