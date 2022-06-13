package com.mercadolibre.fp_be_java_hisp_w15_g05.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.InboundOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.SectionDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.InboundOrderRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.*;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.InboundOrderRepository;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.UserRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {InboundOrderService.class})
@ExtendWith(SpringExtension.class)
class InboundOrderServiceTest {
    @MockBean
    private IBatchService iBatchService;

    @MockBean
    private ISectionService iSectionService;

    @MockBean
    private IWarehouseService iWarehouseService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private SessionServiceImpl sessionService;

    @MockBean
    private InboundOrderRepository inboundOrderRepository;

    @Autowired
    private InboundOrderService inboundOrderService;

    @Test
    @DisplayName("SIO")
    void testSaveInboundOrder() {
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setBatch_stock(new ArrayList<>());
        inboundOrder.setOrder_date(LocalDate.ofEpochDay(1L));
        inboundOrder.setOrder_number(10);
        inboundOrder.setSection_id(1);
        when(this.inboundOrderRepository.save((InboundOrder) any())).thenReturn(inboundOrder);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Leche");
        warehouse.setWarehouse_id(1);
        when(this.iWarehouseService.getExistingWarehouse((Integer) any())).thenReturn(warehouse);

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Almacen");
        warehouse1.setWarehouse_id(1);

        Section section = new Section();
        ArrayList<Batch> batchList = new ArrayList<>();
        section.setBatchList(batchList);
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse1);
        doNothing().when(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        doNothing().when(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        doNothing().when(this.iSectionService).validateHasSpaceAvailable((Integer) any(), (Integer) any(), (Integer) any());
        when(this.iSectionService.getExistingSection((Integer) any())).thenReturn(section);
        when(this.iBatchService.saveBatchList((List<BatchDTO>) any(), (Section) any())).thenReturn(new ArrayList<>());

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSection_code(1);

        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();
        inboundOrderDTO.setBatch_stock(new ArrayList<>());
        inboundOrderDTO.setSection(sectionDTO);

        InboundOrderRequestDTO inboundOrderRequestDTO = new InboundOrderRequestDTO();
        inboundOrderRequestDTO.setInbound_order(inboundOrderDTO);

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");

        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        assertEquals(batchList, this.inboundOrderService.saveInboundOrder(inboundOrderRequestDTO, "Bearer ").getBatch_stock());
        verify(this.inboundOrderRepository).save((InboundOrder) any());
        verify(this.iWarehouseService).getExistingWarehouse((Integer) any());
        verify(this.iSectionService).getExistingSection((Integer) any());
        verify(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        verify(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        verify(this.iSectionService).validateHasSpaceAvailable((Integer) any(), (Integer) any(), (Integer) any());
        verify(this.iBatchService).saveBatchList((List<BatchDTO>) any(), (Section) any());
    }

    @Test
    @DisplayName("SIO 2")
    void testSaveInboundOrder2() {
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setBatch_stock(new ArrayList<>());
        inboundOrder.setOrder_date(LocalDate.ofEpochDay(1L));
        inboundOrder.setOrder_number(10);
        inboundOrder.setSection_id(1);
        when(this.inboundOrderRepository.save((InboundOrder) any())).thenReturn(inboundOrder);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Leche");
        warehouse.setWarehouse_id(1);
        when(this.iWarehouseService.getExistingWarehouse((Integer) any())).thenReturn(warehouse);

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Almacen");
        warehouse1.setWarehouse_id(1);

        Section section = new Section();
        ArrayList<Batch> batchList = new ArrayList<>();
        section.setBatchList(batchList);
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse1);
        doNothing().when(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        doNothing().when(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        doNothing().when(this.iSectionService).validateHasSpaceAvailable((Integer) any(), (Integer) any(), (Integer) any());
        when(this.iSectionService.getExistingSection((Integer) any())).thenReturn(section);
        when(this.iBatchService.saveBatchList((List<BatchDTO>) any(), (Section) any())).thenReturn(new ArrayList<>());

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSection_code(1);
        LocalDate order_date = LocalDate.ofEpochDay(1L);
        SectionDTO section1 = new SectionDTO();

        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, order_date, section1, new ArrayList<>());
        inboundOrderDTO.setBatch_stock(new ArrayList<>());
        inboundOrderDTO.setSection(sectionDTO);

        InboundOrderRequestDTO inboundOrderRequestDTO = new InboundOrderRequestDTO();
        inboundOrderRequestDTO.setInbound_order(inboundOrderDTO);

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");

        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        assertEquals(batchList, this.inboundOrderService.saveInboundOrder(inboundOrderRequestDTO, "Bearer ").getBatch_stock());
        verify(this.inboundOrderRepository).save((InboundOrder) any());
        verify(this.iWarehouseService).getExistingWarehouse((Integer) any());
        verify(this.iSectionService).getExistingSection((Integer) any());
        verify(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        verify(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        verify(this.iSectionService).validateHasSpaceAvailable((Integer) any(), (Integer) any(), (Integer) any());
        verify(this.iBatchService).saveBatchList((List<BatchDTO>) any(), (Section) any());
    }

    @Test
    @DisplayName("SIO 3")
    void testSaveInboundOrder3() {
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setBatch_stock(new ArrayList<>());
        inboundOrder.setOrder_date(LocalDate.ofEpochDay(1L));
        inboundOrder.setOrder_number(10);
        inboundOrder.setSection_id(1);
        when(this.inboundOrderRepository.save((InboundOrder) any())).thenReturn(inboundOrder);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Manteca");
        warehouse.setWarehouse_id(1);
        when(this.iWarehouseService.getExistingWarehouse((Integer) any())).thenReturn(warehouse);

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Almacen");
        warehouse1.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse1);
        doNothing().when(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        doNothing().when(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        doNothing().when(this.iSectionService).validateHasSpaceAvailable((Integer) any(), (Integer) any(), (Integer) any());
        when(this.iSectionService.getExistingSection((Integer) any())).thenReturn(section);
        when(this.iBatchService.saveBatchList((List<BatchDTO>) any(), (Section) any())).thenReturn(new ArrayList<>());

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSection_code(1);

        ArrayList<BatchDTO> batchDTOList = new ArrayList<>();
        batchDTOList.add(new BatchDTO());

        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();
        inboundOrderDTO.setBatch_stock(batchDTOList);
        inboundOrderDTO.setSection(sectionDTO);

        InboundOrderRequestDTO inboundOrderRequestDTO = new InboundOrderRequestDTO();
        inboundOrderRequestDTO.setInbound_order(inboundOrderDTO);

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");

        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        assertEquals(1, this.inboundOrderService.saveInboundOrder(inboundOrderRequestDTO, "Bearer ").getBatch_stock().size());
        verify(this.inboundOrderRepository).save((InboundOrder) any());
        verify(this.iWarehouseService).getExistingWarehouse((Integer) any());
        verify(this.iSectionService).getExistingSection((Integer) any());
        verify(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        verify(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        verify(this.iSectionService).validateHasSpaceAvailable((Integer) any(), (Integer) any(), (Integer) any());
        verify(this.iBatchService).saveBatchList((List<BatchDTO>) any(), (Section) any());
    }

    @Test
    @DisplayName("UIO ")
    void testUpdateInboundOrder() {
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setBatch_stock(new ArrayList<>());
        inboundOrder.setOrder_date(LocalDate.ofEpochDay(1L));
        inboundOrder.setOrder_number(10);
        inboundOrder.setSection_id(1);
        when(this.inboundOrderRepository.save((InboundOrder) any())).thenReturn(inboundOrder);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Queso");
        warehouse.setWarehouse_id(1);
        when(this.iWarehouseService.getExistingWarehouse((Integer) any())).thenReturn(warehouse);

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Almacen");
        warehouse1.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse1);
        when(this.iSectionService.validateSectionSize((List<Batch>) any(), (Integer) any())).thenReturn(1);
        doNothing().when(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        doNothing().when(this.iSectionService).updateSectionSizeChanged((List<Batch>) any(), (Integer) any());
        doNothing().when(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        when(this.iSectionService.getExistingSection((Integer) any())).thenReturn(section);
        when(this.iBatchService.getExistingBatchs((List<BatchDTO>) any())).thenReturn(new ArrayList<>());
        when(this.iBatchService.updateBatchList((List<BatchDTO>) any(), (Section) any())).thenReturn(new ArrayList<>());

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSection_code(1);

        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();
        inboundOrderDTO.setSection(sectionDTO);

        InboundOrderRequestDTO inboundOrderRequestDTO = new InboundOrderRequestDTO();
        inboundOrderRequestDTO.setInbound_order(inboundOrderDTO);

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");

        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        assertNull(this.inboundOrderService.updateInboundOrder(inboundOrderRequestDTO, "Bearer ").getBatch_stock());
        verify(this.inboundOrderRepository).save((InboundOrder) any());
        verify(this.iWarehouseService).getExistingWarehouse((Integer) any());
        verify(this.iSectionService).getExistingSection((Integer) any());
        verify(this.iSectionService).validateSectionSize((List<Batch>) any(), (Integer) any());
        verify(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        verify(this.iSectionService).updateSectionSizeChanged((List<Batch>) any(), (Integer) any());
        verify(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        verify(this.iBatchService).getExistingBatchs((List<BatchDTO>) any());
        verify(this.iBatchService).updateBatchList((List<BatchDTO>) any(), (Section) any());
    }

    @Test
    @DisplayName("UIO 2")
    void testUpdateInboundOrder2() {
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setBatch_stock(new ArrayList<>());
        inboundOrder.setOrder_date(LocalDate.ofEpochDay(1L));
        inboundOrder.setOrder_number(10);
        inboundOrder.setSection_id(1);
        when(this.inboundOrderRepository.save((InboundOrder) any())).thenReturn(inboundOrder);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("LecheLV");
        warehouse.setWarehouse_id(1);
        when(this.iWarehouseService.getExistingWarehouse((Integer) any())).thenReturn(warehouse);

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Almacenote");
        warehouse1.setWarehouse_id(1);

        Section section = new Section();
        ArrayList<Batch> batchList = new ArrayList<>();
        section.setBatchList(batchList);
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse1);
        when(this.iSectionService.validateSectionSize((List<Batch>) any(), (Integer) any())).thenReturn(1);
        doNothing().when(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        doNothing().when(this.iSectionService).updateSectionSizeChanged((List<Batch>) any(), (Integer) any());
        doNothing().when(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        when(this.iSectionService.getExistingSection((Integer) any())).thenReturn(section);
        when(this.iBatchService.getExistingBatchs((List<BatchDTO>) any())).thenReturn(new ArrayList<>());
        when(this.iBatchService.updateBatchList((List<BatchDTO>) any(), (Section) any())).thenReturn(new ArrayList<>());

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSection_code(1);

        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();
        inboundOrderDTO.setBatch_stock(new ArrayList<>());
        inboundOrderDTO.setSection(sectionDTO);

        InboundOrderRequestDTO inboundOrderRequestDTO = new InboundOrderRequestDTO();
        inboundOrderRequestDTO.setInbound_order(inboundOrderDTO);

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");

        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        assertEquals(batchList, this.inboundOrderService.updateInboundOrder(inboundOrderRequestDTO, "Bearer ").getBatch_stock());
        verify(this.inboundOrderRepository).save((InboundOrder) any());
        verify(this.iWarehouseService).getExistingWarehouse((Integer) any());
        verify(this.iSectionService).getExistingSection((Integer) any());
        verify(this.iSectionService).validateSectionSize((List<Batch>) any(), (Integer) any());
        verify(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        verify(this.iSectionService).updateSectionSizeChanged((List<Batch>) any(), (Integer) any());
        verify(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        verify(this.iBatchService).getExistingBatchs((List<BatchDTO>) any());
        verify(this.iBatchService).updateBatchList((List<BatchDTO>) any(), (Section) any());
    }


    @Test
    @DisplayName("UIO 3")
    void testUpdateInboundOrder3() {
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setBatch_stock(new ArrayList<>());
        inboundOrder.setOrder_date(LocalDate.ofEpochDay(1L));
        inboundOrder.setOrder_number(10);
        inboundOrder.setSection_id(1);
        when(this.inboundOrderRepository.save((InboundOrder) any())).thenReturn(inboundOrder);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Leche");
        warehouse.setWarehouse_id(1);
        when(this.iWarehouseService.getExistingWarehouse((Integer) any())).thenReturn(warehouse);

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Almacen");
        warehouse1.setWarehouse_id(1);

        Section section = new Section();
        ArrayList<Batch> batchList = new ArrayList<>();
        section.setBatchList(batchList);
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse1);
        when(this.iSectionService.validateSectionSize((List<Batch>) any(), (Integer) any())).thenReturn(1);
        doNothing().when(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        doNothing().when(this.iSectionService).updateSectionSizeChanged((List<Batch>) any(), (Integer) any());
        doNothing().when(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        when(this.iSectionService.getExistingSection((Integer) any())).thenReturn(section);
        when(this.iBatchService.getExistingBatchs((List<BatchDTO>) any())).thenReturn(new ArrayList<>());
        when(this.iBatchService.updateBatchList((List<BatchDTO>) any(), (Section) any())).thenReturn(new ArrayList<>());

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSection_code(1);
        LocalDate order_date = LocalDate.ofEpochDay(1L);
        SectionDTO section1 = new SectionDTO();

        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, order_date, section1, new ArrayList<>());
        inboundOrderDTO.setSection(sectionDTO);

        InboundOrderRequestDTO inboundOrderRequestDTO = new InboundOrderRequestDTO();
        inboundOrderRequestDTO.setInbound_order(inboundOrderDTO);

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");

        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        assertEquals(batchList, this.inboundOrderService.updateInboundOrder(inboundOrderRequestDTO, "Bearer ").getBatch_stock());
        verify(this.inboundOrderRepository).save((InboundOrder) any());
        verify(this.iWarehouseService).getExistingWarehouse((Integer) any());
        verify(this.iSectionService).getExistingSection((Integer) any());
        verify(this.iSectionService).validateSectionSize((List<Batch>) any(), (Integer) any());
        verify(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        verify(this.iSectionService).updateSectionSizeChanged((List<Batch>) any(), (Integer) any());
        verify(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        verify(this.iBatchService).getExistingBatchs((List<BatchDTO>) any());
        verify(this.iBatchService).updateBatchList((List<BatchDTO>) any(), (Section) any());
    }

    @Test
    @DisplayName("UIO 4")
    void testUpdateInboundOrder4() {
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setBatch_stock(new ArrayList<>());
        inboundOrder.setOrder_date(LocalDate.ofEpochDay(1L));
        inboundOrder.setOrder_number(10);
        inboundOrder.setSection_id(1);
        when(this.inboundOrderRepository.save((InboundOrder) any())).thenReturn(inboundOrder);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("MantecaLS");
        warehouse.setWarehouse_id(1);
        when(this.iWarehouseService.getExistingWarehouse((Integer) any())).thenReturn(warehouse);

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("LaSere");
        warehouse1.setWarehouse_id(1);

        Section section = new Section();
        ArrayList<Batch> batchList = new ArrayList<>();
        section.setBatchList(batchList);
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse1);
        when(this.iSectionService.validateSectionSize((List<Batch>) any(), (Integer) any())).thenReturn(1);
        doNothing().when(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        doNothing().when(this.iSectionService).updateSectionSizeChanged((List<Batch>) any(), (Integer) any());
        doNothing().when(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        when(this.iSectionService.getExistingSection((Integer) any())).thenReturn(section);
        when(this.iBatchService.getExistingBatchs((List<BatchDTO>) any())).thenReturn(new ArrayList<>());
        when(this.iBatchService.updateBatchList((List<BatchDTO>) any(), (Section) any())).thenReturn(new ArrayList<>());

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSection_code(1);
        InboundOrderDTO inboundOrderDTO = mock(InboundOrderDTO.class);
        when(inboundOrderDTO.getOrder_number()).thenReturn(10);
        when(inboundOrderDTO.getOrder_date()).thenReturn(LocalDate.ofEpochDay(1L));
        when(inboundOrderDTO.getSection()).thenReturn(new SectionDTO());
        when(inboundOrderDTO.getBatch_stock()).thenReturn(new ArrayList<>());
        doNothing().when(inboundOrderDTO).setSection((SectionDTO) any());
        inboundOrderDTO.setSection(sectionDTO);

        InboundOrderRequestDTO inboundOrderRequestDTO = new InboundOrderRequestDTO();
        inboundOrderRequestDTO.setInbound_order(inboundOrderDTO);

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");

        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        assertEquals(batchList, this.inboundOrderService.updateInboundOrder(inboundOrderRequestDTO, "Bearer ").getBatch_stock());
        verify(this.inboundOrderRepository).save((InboundOrder) any());
        verify(this.iWarehouseService).getExistingWarehouse((Integer) any());
        verify(this.iSectionService).getExistingSection((Integer) any());
        verify(this.iSectionService).validateSectionSize((List<Batch>) any(), (Integer) any());
        verify(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        verify(this.iSectionService).updateSectionSizeChanged((List<Batch>) any(), (Integer) any());
        verify(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        verify(this.iBatchService).getExistingBatchs((List<BatchDTO>) any());
        verify(this.iBatchService).updateBatchList((List<BatchDTO>) any(), (Section) any());
        verify(inboundOrderDTO, atLeast(1)).getSection();
        verify(inboundOrderDTO).getOrder_number();
        verify(inboundOrderDTO).getOrder_date();
        verify(inboundOrderDTO, atLeast(1)).getBatch_stock();
        verify(inboundOrderDTO).setSection((SectionDTO) any());
    }

    @Test
    @DisplayName("UIO 5")
    void testUpdateInboundOrder5() {
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setBatch_stock(new ArrayList<>());
        inboundOrder.setOrder_date(LocalDate.ofEpochDay(1L));
        inboundOrder.setOrder_number(10);
        inboundOrder.setSection_id(1);
        when(this.inboundOrderRepository.save((InboundOrder) any())).thenReturn(inboundOrder);

        Warehouse warehouse = new Warehouse();
        warehouse.setName("Quesos");
        warehouse.setWarehouse_id(1);
        when(this.iWarehouseService.getExistingWarehouse((Integer) any())).thenReturn(warehouse);

        SectionType sectionType = new SectionType();
        sectionType.setId(123L);
        sectionType.setType(SectionTypeE.FRESH);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Almacen");
        warehouse1.setWarehouse_id(1);

        Section section = new Section();
        section.setBatchList(new ArrayList<>());
        section.setCurrent_size(3);
        section.setSection_id(1);
        section.setTotal_size(3);
        section.setType(sectionType);
        section.setWarehouse(warehouse1);
        when(this.iSectionService.validateSectionSize((List<Batch>) any(), (Integer) any())).thenReturn(1);
        doNothing().when(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        doNothing().when(this.iSectionService).updateSectionSizeChanged((List<Batch>) any(), (Integer) any());
        doNothing().when(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        when(this.iSectionService.getExistingSection((Integer) any())).thenReturn(section);
        when(this.iBatchService.getExistingBatchs((List<BatchDTO>) any())).thenReturn(new ArrayList<>());
        when(this.iBatchService.updateBatchList((List<BatchDTO>) any(), (Section) any())).thenReturn(new ArrayList<>());

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSection_code(1);

        ArrayList<BatchDTO> batchDTOList = new ArrayList<>();
        batchDTOList.add(new BatchDTO());
        InboundOrderDTO inboundOrderDTO = mock(InboundOrderDTO.class);
        when(inboundOrderDTO.getOrder_number()).thenReturn(10);
        when(inboundOrderDTO.getOrder_date()).thenReturn(LocalDate.ofEpochDay(1L));
        when(inboundOrderDTO.getSection()).thenReturn(new SectionDTO());
        when(inboundOrderDTO.getBatch_stock()).thenReturn(batchDTOList);
        doNothing().when(inboundOrderDTO).setSection((SectionDTO) any());
        inboundOrderDTO.setSection(sectionDTO);

        InboundOrderRequestDTO inboundOrderRequestDTO = new InboundOrderRequestDTO();
        inboundOrderRequestDTO.setInbound_order(inboundOrderDTO);

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");

        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        assertEquals(1, this.inboundOrderService.updateInboundOrder(inboundOrderRequestDTO, "Bearer ").getBatch_stock().size());
        verify(this.inboundOrderRepository).save((InboundOrder) any());
        verify(this.iWarehouseService).getExistingWarehouse((Integer) any());
        verify(this.iSectionService).getExistingSection((Integer) any());
        verify(this.iSectionService).validateSectionSize((List<Batch>) any(), (Integer) any());
        verify(this.iSectionService).updateSectionSize((Integer) any(), (Integer) any());
        verify(this.iSectionService).updateSectionSizeChanged((List<Batch>) any(), (Integer) any());
        verify(this.iSectionService).validateCorrectSectionType((Integer) any(), (List<BatchDTO>) any());
        verify(this.iBatchService).getExistingBatchs((List<BatchDTO>) any());
        verify(this.iBatchService).updateBatchList((List<BatchDTO>) any(), (Section) any());
        verify(inboundOrderDTO, atLeast(1)).getSection();
        verify(inboundOrderDTO).getOrder_number();
        verify(inboundOrderDTO).getOrder_date();
        verify(inboundOrderDTO, atLeast(1)).getBatch_stock();
        verify(inboundOrderDTO).setSection((SectionDTO) any());
    }
}

