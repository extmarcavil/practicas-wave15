package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.InboundOrderRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.InboundOrderResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.InvalidRolException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.*;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboundOrderService implements IInboundOrderService {

    private InboundOrderRepository inboundOrderRepository;
    private IWarehouseService warehouseService;
    private ISectionService sectionService;
    private IBatchService batchService;
    private SessionServiceImpl sessionService;
    private ModelMapper modelMapper;

    public InboundOrderService(InboundOrderRepository inboundOrderRepository, IWarehouseService warehouseService,
                               ISectionService sectionService, IBatchService batchService,
                               SessionServiceImpl sessionService) {
        this.inboundOrderRepository = inboundOrderRepository;
        this.warehouseService = warehouseService;
        this.sectionService = sectionService;
        this.batchService = batchService;
        this.sessionService = sessionService;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public InboundOrderResponseDTO saveInboundOrder(InboundOrderRequestDTO inboundOrderRequest, String token) {
        List<BatchDTO> batchStock = inboundOrderRequest.getInbound_order().getBatch_stock();

        String username = sessionService.getUsername(token.replace("Bearer ",""));
        User user = sessionService.getUserByName(username);
        validateUserRol(user);

        warehouseService.getExistingWarehouse(inboundOrderRequest.getInbound_order().getSection().getWarehouse_code());
        Section section = sectionService.getExistingSection(inboundOrderRequest.getInbound_order().getSection().getSection_code());
        sectionService.validateHasSpaceAvailable(section.getCurrent_size(), section.getTotal_size(), batchStock.size());
        sectionService.validateCorrectSectionType(section.getSection_id(), batchStock);
        List<Batch> batchs = batchService.saveBatchList(batchStock, section);
        sectionService.updateSectionSize(section.getSection_id(), batchStock.size());

        InboundOrder inboundOrder = modelMapper.map(inboundOrderRequest.getInbound_order(), InboundOrder.class);
        inboundOrder.setSection_id(section.getSection_id());
        inboundOrder.setBatch_stock(batchs);
        inboundOrderRepository.save(inboundOrder);

        return new InboundOrderResponseDTO(batchStock);

    }

    private void validateUserRol(User user) {
        if(user.getRol().getRol() != RolE.REP)
            throw new InvalidRolException();
    }

    public InboundOrderResponseDTO updateInboundOrder(InboundOrderRequestDTO inboundOrderRequest, String token) {
        List<BatchDTO> batchStock = inboundOrderRequest.getInbound_order().getBatch_stock();

        User user = sessionService.getUserByName(sessionService.getUsername(token.replace("Bearer ","")));
        validateUserRol(user);

        List<Batch> existingBatchs = batchService.getExistingBatchs(batchStock);

        warehouseService.getExistingWarehouse(inboundOrderRequest.getInbound_order().getSection().getWarehouse_code());
        Section section = sectionService.getExistingSection(inboundOrderRequest.getInbound_order().getSection().getSection_code());
        Integer amountToAdd = sectionService.validateSectionSize(existingBatchs, section.getSection_id());
        sectionService.validateCorrectSectionType(section.getSection_id(), batchStock);

        List<Batch> batchs = batchService.updateBatchList(batchStock, section);

        sectionService.updateSectionSize(section.getSection_id(), amountToAdd);
        sectionService.updateSectionSizeChanged(existingBatchs, section.getSection_id());

        InboundOrder inboundOrder = modelMapper.map(inboundOrderRequest.getInbound_order(), InboundOrder.class);
        inboundOrder.setSection_id(section.getSection_id());
        inboundOrder.setBatch_stock(batchs);
        inboundOrderRepository.save(inboundOrder);

        return new InboundOrderResponseDTO(batchStock);
    }

}
