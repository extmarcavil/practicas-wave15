package com.mercadolibre.fp_be_java_hisp_w15_g05.utils;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Section;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Warehouse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class BatchFactory {

    public static List<Batch> batchListSavePurchase(){
        Batch b = new Batch(
                1,
                null,
                null,
                null,
                LocalDate.of(2122,12,31),
                300,
                300,
                LocalDateTime.now(),
                LocalDateTime.now(),
                1,
                2
        );

        return Arrays.asList(b);
}

    public static List<BatchDTO> getbatchDTOList() {
        BatchDTO batch = new BatchDTO();
        batch.setMinimum_temperature(10D);
        batch.setBatch_number(1);
        batch.setCurrent_quantity(20);
        batch.setProduct_id(3);
        batch.setInitial_quantity(20);
        return List.of(batch);
    }

    public static Batch getBatch() {
        Batch batch = new Batch();
        batch.setMinimum_temperature(10D);
        batch.setBatch_number(1);
        batch.setProduct(new Product());
        Section section = new Section();
        section.setWarehouse(new Warehouse(1, ""));
        batch.setSection(section);
        batch.setCurrent_quantity(1);
        batch.setDue_date(LocalDate.now().plusWeeks(4));
        Product product = ProductFactory.getProducto();
        batch.setProduct(product);
        return batch;
    }

    public static Batch getBatch2() {
        Batch batch = new Batch();
        batch.setMinimum_temperature(10D);
        batch.setBatch_number(1);
        batch.setProduct(new Product());
        batch.setSection(new Section());
        return batch;
    }

    public static BatchDTO getBatchDTO() {
        BatchDTO batch = new BatchDTO();
        batch.setMinimum_temperature(10D);
        batch.setBatch_number(1);
        return batch;
    }

    public static List<Batch> getbatchList() {
        Section section = new Section();
        section.setCurrent_size(10);
        section.setSection_id(2);

        Batch batch = new Batch();
        batch.setMinimum_temperature(10D);
        batch.setBatch_number(1);
        batch.setSection(section);
        return List.of(batch);
    }

    public static List<Batch> getbatchList2() {
        Section section = SectionFactory.getSectionWithId2();

        Batch batch = new Batch();
        batch.setMinimum_temperature(10D);
        batch.setBatch_number(1);
        batch.setSection(section);
        section.setCurrent_size(10);
        return List.of(batch);
    }
}
