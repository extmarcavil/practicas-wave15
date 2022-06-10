package com.mercadolibre.fp_be_java_hisp_w15_g06.factory;

import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.*;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class SectionFactory {

    Batch batch = new Batch(1l, 1.2, 1.2, 24, 50, LocalDateTime.now(), LocalDate.now(), section(),
                 new Product(1L, "Milk", Category.RF, 15.0), null);

    public static Section section() {
        return new Section(1L,Category.RF, 1, 1.2,15.0, emptyList());

    }
}
