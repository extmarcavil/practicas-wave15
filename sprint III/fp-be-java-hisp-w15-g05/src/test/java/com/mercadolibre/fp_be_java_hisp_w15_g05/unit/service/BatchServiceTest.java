package com.mercadolibre.fp_be_java_hisp_w15_g05.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.InvalidFieldException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Section;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.SectionType;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.SectionTypeE;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Warehouse;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.BatchRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.fp_be_java_hisp_w15_g05.service.BatchService;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.IProductService;
import com.mercadolibre.fp_be_java_hisp_w15_g05.utils.BatchFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BatchService.class})
@ExtendWith(SpringExtension.class)
class BatchServiceTest {
    @MockBean
    private BatchRepository batchRepository;

    @Autowired
    private BatchService batchService;

    @MockBean
    private IProductService iProductService;

    @Test
    @DisplayName("Trae el batch")
    void testGetBatch() {
        Product product = new Product();
        product.setBatchList(new ArrayList<>());
        product.setName("Leche");
        product.setProduct_id(1);
        product.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Almacen");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(30);
        section.setSection_id(1);
        section.setTotal_size(30);
        section.setType(sectionType);
        section.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setBatch_number(10);
        batch.setCurrent_quantity(1);
        batch.setCurrent_temperature(10.0d);
        batch.setDue_date(LocalDate.ofEpochDay(1L));
        batch.setInboundOrderList(new ArrayList<>());
        batch.setInitial_quantity(10);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch.setMinimum_temperature(10.0d);
        batch.setProduct(product);
        batch.setSection(section);
        when(this.batchRepository.findByBatch_number((Integer) any())).thenReturn(batch);
        assertSame(batch, this.batchService.getBatch(1));
        verify(this.batchRepository).findByBatch_number((Integer) any());
    }

    @Test
    @DisplayName("Verificación lanzado de excepción")
    void testGetBatch2() {
        when(this.batchRepository.findByBatch_number((Integer) any()))
                .thenThrow(new InvalidFieldException("An error occurred"));
        assertThrows(InvalidFieldException.class, () -> this.batchService.getBatch(1));
        verify(this.batchRepository).findByBatch_number((Integer) any());
    }

    @Test
    @DisplayName("Verificación de valid batch")
    void testValidateBatchDoesNotExist() {
        Product product = new Product();
        product.setBatchList(new ArrayList<>());
        product.setName("Leche");
        product.setProduct_id(1);
        product.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Almacen");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setBatch_number(10);
        batch.setCurrent_quantity(1);
        batch.setCurrent_temperature(10.0d);
        batch.setDue_date(LocalDate.ofEpochDay(1L));
        batch.setInboundOrderList(new ArrayList<>());
        batch.setInitial_quantity(1);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch.setMinimum_temperature(10.0d);
        batch.setProduct(product);
        batch.setSection(section);
        when(this.batchRepository.findByBatch_number((Integer) any())).thenReturn(batch);
        assertThrows(InvalidFieldException.class, () -> this.batchService.validateBatchDoesNotExist(1));
        verify(this.batchRepository).findByBatch_number((Integer) any());
    }

    @Test
    @DisplayName("Verificación lanzado de excepción")
    void testValidateBatchDoesNotExist2() {
        when(this.batchRepository.findByBatch_number((Integer) any()))
                .thenThrow(new InvalidFieldException("An error occurred"));
        assertThrows(InvalidFieldException.class, () -> this.batchService.validateBatchDoesNotExist(1));
        verify(this.batchRepository).findByBatch_number((Integer) any());
    }

    @Test
    @DisplayName("Valida batch con dato")
    void testValidateBatchExistance() {
        Product product = new Product();
        product.setBatchList(new ArrayList<>());
        product.setName("Leche");
        product.setProduct_id(1);
        product.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Almacen");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(30);
        section.setSection_id(1);
        section.setTotal_size(30);
        section.setType(sectionType);
        section.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setBatch_number(10);
        batch.setCurrent_quantity(1);
        batch.setCurrent_temperature(10.0d);
        batch.setDue_date(LocalDate.ofEpochDay(1L));
        batch.setInboundOrderList(new ArrayList<>());
        batch.setInitial_quantity(1);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch.setMinimum_temperature(10.0d);
        batch.setProduct(product);
        batch.setSection(section);
        when(this.batchRepository.findByBatch_number((Integer) any())).thenReturn(batch);
        assertSame(batch, this.batchService.validateBatchExistance(1));
        verify(this.batchRepository).findByBatch_number((Integer) any());
    }

    @Test
    @DisplayName("Valida existencia excepcion")
    void testValidateBatchExistance2() {
        when(this.batchRepository.findByBatch_number((Integer) any()))
                .thenThrow(new InvalidFieldException("An error occurred"));
        assertThrows(InvalidFieldException.class, () -> this.batchService.validateBatchExistance(1));
        verify(this.batchRepository).findByBatch_number((Integer) any());
    }

    @Test
    @DisplayName("Existe batch vacio")
    void testGetExistingBatchs() {
        assertTrue(this.batchService.getExistingBatchs(new ArrayList<>()).isEmpty());
    }

    @Test
    @DisplayName("Existe batch con datos")
    void testGetExistingBatchs2() {
        Product product = new Product();
        product.setBatchList(new ArrayList<>());
        product.setName("Leche");
        product.setProduct_id(1);
        product.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Almacen");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setBatch_number(10);
        batch.setCurrent_quantity(1);
        batch.setCurrent_temperature(10.0d);
        batch.setDue_date(LocalDate.ofEpochDay(1L));
        batch.setInboundOrderList(new ArrayList<>());
        batch.setInitial_quantity(1);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch.setMinimum_temperature(10.0d);
        batch.setProduct(product);
        batch.setSection(section);
        when(this.batchRepository.findByBatch_number((Integer) any())).thenReturn(batch);

        ArrayList<BatchDTO> batchDTOList = new ArrayList<>();
        batchDTOList.add(new BatchDTO());
        assertEquals(1, this.batchService.getExistingBatchs(batchDTOList).size());
        verify(this.batchRepository).findByBatch_number((Integer) any());
    }

    @Test
    @DisplayName("Guarda Batch")
    void testSaveBatch() {
        Product product = new Product();
        product.setBatchList(new ArrayList<>());
        product.setName("Leche");
        product.setProduct_id(1);
        product.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Almacen");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(30);
        section.setSection_id(1);
        section.setTotal_size(30);
        section.setType(sectionType);
        section.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setBatch_number(10);
        batch.setCurrent_quantity(1);
        batch.setCurrent_temperature(10.0d);
        batch.setDue_date(LocalDate.ofEpochDay(1L));
        batch.setInboundOrderList(new ArrayList<>());
        batch.setInitial_quantity(1);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch.setMinimum_temperature(10.0d);
        batch.setProduct(product);
        batch.setSection(section);

        Product product1 = new Product();
        product1.setBatchList(new ArrayList<>());
        product1.setName("Leche");
        product1.setProduct_id(1);
        product1.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType1 = new SectionType();
        sectionType1.setId(123L);
        sectionType1.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Almacen");
        warehouse1.setWarehouse_id(1);

        Section section1 = new Section();
        section1.setBatchList(new ArrayList<>());
        section1.setCurrent_size(3);
        section1.setSection_id(1);
        section1.setTotal_size(3);
        section1.setType(sectionType1);
        section1.setWarehouse(warehouse1);

        Batch batch1 = new Batch();
        batch1.setBatch_number(10);
        batch1.setCurrent_quantity(1);
        batch1.setCurrent_temperature(10.0d);
        batch1.setDue_date(LocalDate.ofEpochDay(1L));
        batch1.setInboundOrderList(new ArrayList<>());
        batch1.setInitial_quantity(1);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch1.setMinimum_temperature(10.0d);
        batch1.setProduct(product1);
        batch1.setSection(section1);
        when(this.batchRepository.findByBatch_number((Integer) any())).thenReturn(batch);
        when(this.batchRepository.save((Batch) any())).thenReturn(batch1);
        BatchDTO batchDTO = new BatchDTO();

        Product product2 = new Product();
        product2.setBatchList(new ArrayList<>());
        product2.setName("Manteca");
        product2.setProduct_id(1);
        product2.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType2 = new SectionType();
        sectionType2.setId(123L);
        sectionType2.setType(SectionTypeE.FRESH);

        Warehouse warehouse2 = new Warehouse();
        warehouse2.setName("Almacenito");
        warehouse2.setWarehouse_id(1);

        Section section2 = new Section();
        section2.setBatchList(new ArrayList<>());
        section2.setCurrent_size(3);
        section2.setSection_id(1);
        section2.setTotal_size(3);
        section2.setType(sectionType2);
        section2.setWarehouse(warehouse2);
        assertThrows(InvalidFieldException.class, () -> this.batchService.saveBatch(batchDTO, product2, section2));
        verify(this.batchRepository).findByBatch_number((Integer) any());
    }

    @Test
    @DisplayName("Updatea batch")
    void testUpdateBatch() {
        Product product = new Product();
        product.setBatchList(new ArrayList<>());
        product.setName("LecheLargavida");
        product.setProduct_id(1);
        product.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Almacenazo");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setCurrent_size(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setBatch_number(10);
        batch.setCurrent_quantity(1);
        batch.setCurrent_temperature(10.0d);
        batch.setDue_date(LocalDate.ofEpochDay(1L));
        batch.setInboundOrderList(new ArrayList<>());
        batch.setInitial_quantity(1);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch.setMinimum_temperature(10.0d);
        batch.setProduct(product);
        batch.setSection(section);

        Product product1 = new Product();
        product1.setBatchList(new ArrayList<>());
        product1.setName("Leche");
        product1.setProduct_id(1);
        product1.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType1 = new SectionType();
        sectionType1.setId(123L);
        sectionType1.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Almacen");
        warehouse1.setWarehouse_id(1);

        Section section1 = new Section();
        section1.setBatchList(new ArrayList<>());
        section1.setCurrent_size(3);
        section1.setSection_id(1);
        section1.setTotal_size(3);
        section1.setType(sectionType1);
        section1.setWarehouse(warehouse1);

        Batch batch1 = new Batch();
        batch1.setBatch_number(10);
        batch1.setCurrent_quantity(1);
        batch1.setCurrent_temperature(10.0d);
        batch1.setDue_date(LocalDate.ofEpochDay(1L));
        batch1.setInboundOrderList(new ArrayList<>());
        batch1.setInitial_quantity(10);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch1.setMinimum_temperature(10.0d);
        batch1.setProduct(product1);
        batch1.setSection(section1);
        when(this.batchRepository.save((Batch) any())).thenReturn(batch1);
        when(this.batchRepository.findByBatch_number((Integer) any())).thenReturn(batch);
        BatchDTO batchDTO = new BatchDTO();

        Product product2 = new Product();
        product2.setBatchList(new ArrayList<>());
        product2.setName("Manteca");
        product2.setProduct_id(1);
        product2.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType2 = new SectionType();
        sectionType2.setId(123L);
        sectionType2.setType(SectionTypeE.FRESH);

        Warehouse warehouse2 = new Warehouse();
        warehouse2.setName("Almacenito");
        warehouse2.setWarehouse_id(1);

        Section section2 = new Section();
        section2.setBatchList(new ArrayList<>());
        section2.setCurrent_size(3);
        section2.setSection_id(1);
        section2.setTotal_size(3);
        section2.setType(sectionType2);
        section2.setWarehouse(warehouse2);
        Batch actualUpdateBatchResult = this.batchService.updateBatch(batchDTO, product2, section2);
        assertNull(actualUpdateBatchResult.getBatch_number());
        assertSame(section2, actualUpdateBatchResult.getSection());
        assertSame(product2, actualUpdateBatchResult.getProduct());
        assertEquals(0, actualUpdateBatchResult.getCurrent_quantity());
        assertNull(actualUpdateBatchResult.getDue_date());
        assertNull(actualUpdateBatchResult.getManufacturing_time());
        assertEquals(0.0d, actualUpdateBatchResult.getMinimum_temperature());
        assertEquals(0.0d, actualUpdateBatchResult.getCurrent_temperature());
        assertEquals(0, actualUpdateBatchResult.getInitial_quantity());
        assertNull(actualUpdateBatchResult.getManufacturing_date());
        verify(this.batchRepository).findByBatch_number((Integer) any());
        verify(this.batchRepository).save((Batch) any());
    }

    @Test
    @DisplayName("Updatea batch con dato existente")
    void testUpdateBatch2() {
        Product product = new Product();
        product.setBatchList(new ArrayList<>());
        product.setName("Leche");
        product.setProduct_id(1);
        product.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Almacen");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setBatch_number(10);
        batch.setCurrent_quantity(1);
        batch.setCurrent_temperature(10.0d);
        batch.setDue_date(LocalDate.ofEpochDay(1L));
        batch.setInboundOrderList(new ArrayList<>());
        batch.setInitial_quantity(1);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch.setMinimum_temperature(10.0d);
        batch.setProduct(product);
        batch.setSection(section);
        when(this.batchRepository.save((Batch) any())).thenThrow(new InvalidFieldException("An error occurred"));
        when(this.batchRepository.findByBatch_number((Integer) any())).thenReturn(batch);
        BatchDTO batchDTO = new BatchDTO();

        Product product1 = new Product();
        product1.setBatchList(new ArrayList<>());
        product1.setName("Manteca");
        product1.setProduct_id(1);
        product1.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType1 = new SectionType();
        sectionType1.setId(123L);
        sectionType1.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Almacennn");
        warehouse1.setWarehouse_id(1);

        Section section1 = new Section();
        section1.setBatchList(new ArrayList<>());
        section1.setCurrent_size(3);
        section1.setSection_id(1);
        section1.setTotal_size(3);
        section1.setType(sectionType1);
        section1.setWarehouse(warehouse1);
        assertThrows(InvalidFieldException.class, () -> this.batchService.updateBatch(batchDTO, product1, section1));
        verify(this.batchRepository).findByBatch_number((Integer) any());
        verify(this.batchRepository).save((Batch) any());
    }

    @Test
    @DisplayName("Guarda lista batch")
    void testSaveBatchList() {
        ArrayList<BatchDTO> batchsDTO = new ArrayList<>();

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Almacen");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse);
        assertTrue(this.batchService.saveBatchList(batchsDTO, section).isEmpty());
    }

    @Test
    @DisplayName("Guarda batch con 2+Prod")
    void testSaveBatchList2() {
        Product product = new Product();
        product.setBatchList(new ArrayList<>());
        product.setName("Leche");
        product.setProduct_id(1);
        product.setPurchaseOrderProductByNumber(new ArrayList<>());
        when(this.iProductService.findById((Integer) any())).thenReturn(product);

        Product product1 = new Product();
        product1.setBatchList(new ArrayList<>());
        product1.setName("Manteca");
        product1.setProduct_id(2);
        product1.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Almacen");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setBatch_number(10);
        batch.setCurrent_quantity(1);
        batch.setCurrent_temperature(1.0d);
        batch.setDue_date(LocalDate.ofEpochDay(1L));
        batch.setInboundOrderList(new ArrayList<>());
        batch.setInitial_quantity(1);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch.setMinimum_temperature(1.0d);
        batch.setProduct(product1);
        batch.setSection(section);

        Product product2 = new Product();
        product2.setBatchList(new ArrayList<>());
        product2.setName("Carne");
        product2.setProduct_id(1);
        product2.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType1 = new SectionType();
        sectionType1.setId(123L);
        sectionType1.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Carniceria");
        warehouse1.setWarehouse_id(1);

        Section section1 = new Section();
        section1.setBatchList(new ArrayList<>());
        section1.setCurrent_size(3);
        section1.setSection_id(1);
        section1.setTotal_size(3);
        section1.setType(sectionType1);
        section1.setWarehouse(warehouse1);

        Batch batch1 = new Batch();
        batch1.setBatch_number(10);
        batch1.setCurrent_quantity(1);
        batch1.setCurrent_temperature(10.0d);
        batch1.setDue_date(LocalDate.ofEpochDay(1L));
        batch1.setInboundOrderList(new ArrayList<>());
        batch1.setInitial_quantity(1);
        batch1.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch1.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch1.setMinimum_temperature(10.0d);
        batch1.setProduct(product2);
        batch1.setSection(section1);
        when(this.batchRepository.findByBatch_number((Integer) any())).thenReturn(batch);
        when(this.batchRepository.save((Batch) any())).thenReturn(batch1);

        ArrayList<BatchDTO> batchDTOList = new ArrayList<>();
        batchDTOList.add(new BatchDTO());

        SectionType sectionType2 = new SectionType();
        sectionType2.setId(123L);
        sectionType2.setType(SectionTypeE.FRESH);

        Warehouse warehouse2 = new Warehouse();
        warehouse2.setName("Carniceria");
        warehouse2.setWarehouse_id(1);

        Section section2 = new Section();
        section2.setBatchList(new ArrayList<>());
        section2.setCurrent_size(3);
        section2.setSection_id(1);
        section2.setTotal_size(3);
        section2.setType(sectionType2);
        section2.setWarehouse(warehouse2);
        assertThrows(InvalidFieldException.class, () -> this.batchService.saveBatchList(batchDTOList, section2));
        verify(this.iProductService).findById((Integer) any());
        verify(this.batchRepository).findByBatch_number((Integer) any());
    }


    @Test
    @DisplayName("Actualiza lista")
    void testUpdateBatchList() {
        ArrayList<BatchDTO> batchsDTO = new ArrayList<>();

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Leche");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse);
        assertTrue(this.batchService.updateBatchList(batchsDTO, section).isEmpty());
    }


    @Test
    @DisplayName("Actualiza multiples datos")
    void testUpdateBatchList2() {
        Product product = new Product();
        product.setBatchList(new ArrayList<>());
        product.setName("Name");
        product.setProduct_id(1);
        product.setPurchaseOrderProductByNumber(new ArrayList<>());
        when(this.iProductService.findById((Integer) any())).thenReturn(product);

        Product product1 = new Product();
        product1.setBatchList(new ArrayList<>());
        product1.setName("LecheChocolatada");
        product1.setProduct_id(1);
        product1.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("RogelioAlmacen");
        warehouse.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setBatch_number(10);
        batch.setCurrent_quantity(1);
        batch.setCurrent_temperature(10.0d);
        batch.setDue_date(LocalDate.ofEpochDay(1L));
        batch.setInboundOrderList(new ArrayList<>());
        batch.setInitial_quantity(1);
        batch.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch.setMinimum_temperature(10.0d);
        batch.setProduct(product1);
        batch.setSection(section);

        Product product2 = new Product();
        product2.setBatchList(new ArrayList<>());
        product2.setName("LecheLV");
        product2.setProduct_id(1);
        product2.setPurchaseOrderProductByNumber(new ArrayList<>());

        SectionType sectionType1 = new SectionType();
        sectionType1.setId(123L);
        sectionType1.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("RogelAlmacen");
        warehouse1.setWarehouse_id(1);

        Section section1 = new Section();
        section1.setBatchList(new ArrayList<>());
        section1.setCurrent_size(3);
        section1.setSection_id(1);
        section1.setTotal_size(3);
        section1.setType(sectionType1);
        section1.setWarehouse(warehouse1);

        Batch batch1 = new Batch();
        batch1.setBatch_number(10);
        batch1.setCurrent_quantity(1);
        batch1.setCurrent_temperature(10.0d);
        batch1.setDue_date(LocalDate.ofEpochDay(1L));
        batch1.setInboundOrderList(new ArrayList<>());
        batch1.setInitial_quantity(1);
        batch1.setManufacturing_date(LocalDateTime.of(2022, 6, 6, 16, 33));
        batch1.setManufacturing_time(LocalDateTime.of(2022, 6, 6, 16, 32));
        batch1.setMinimum_temperature(10.0d);
        batch1.setProduct(product2);
        batch1.setSection(section1);
        when(this.batchRepository.save((Batch) any())).thenReturn(batch1);
        when(this.batchRepository.findByBatch_number((Integer) any())).thenReturn(batch);

        ArrayList<BatchDTO> batchDTOList = new ArrayList<>();
        batchDTOList.add(new BatchDTO());

        SectionType sectionType2 = new SectionType();
        sectionType2.setId(123L);
        sectionType2.setType(SectionTypeE.FRESH);

        Warehouse warehouse2 = new Warehouse();
        warehouse2.setName("PruebaAlmacen");
        warehouse2.setWarehouse_id(1);

        Section section2 = new Section();
        section2.setBatchList(new ArrayList<>());
        section2.setCurrent_size(3);
        section2.setSection_id(1);
        section2.setTotal_size(3);
        section2.setType(sectionType2);
        section2.setWarehouse(warehouse2);
        assertEquals(1, this.batchService.updateBatchList(batchDTOList, section2).size());
        verify(this.iProductService).findById((Integer) any());
        verify(this.batchRepository).findByBatch_number((Integer) any());
        verify(this.batchRepository).save((Batch) any());
    }


    @Test
    void saveBatchTest() {
        Batch batch = BatchFactory.getBatch2();
        when(batchRepository.save(batch)).thenReturn(batch);
        Batch response = batchService.saveBatch(BatchFactory.getBatchDTO(), new Product(), new Section());
        assertEquals(batch, response);
    }

    @Test
    void validateBatchDoesExist() {
        when(batchRepository.findByBatch_number(1)).thenReturn(new Batch());
        Assertions.assertThrows(
                InvalidFieldException.class,
                () -> batchService.validateBatchDoesNotExist(1));
    }
}



