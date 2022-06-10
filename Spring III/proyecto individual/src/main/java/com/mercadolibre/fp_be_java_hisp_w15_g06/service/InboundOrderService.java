package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.BatchStockDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.InboundOrderRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.InboundOrderResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.InvalidProductException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.InvalidWarehouseException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IAgentRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IInboundOrderRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IProductRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IWarehouseRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.BatchStockDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.*;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.*;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class InboundOrderService implements IInboundOrderService {

    private final IInboundOrderRepository inboundOrderRepository;
    private final IProductRepository productRepository;
    private final IWarehouseRepository warehouseRepository;
    private final IAgentRepository agentRepository;
    private final IUserRepository userRepository;
    private final ISectionRepository sectionRepository;
    private final IBatchRepository batchRepository;

    public InboundOrderService(IInboundOrderRepository inboundOrderRepository,
                               IProductRepository productRepository,
                               IWarehouseRepository warehouseRepository,
                               IAgentRepository agentRepository,
                               IUserRepository userRepository,
                               ISectionRepository sectionRepository, IBatchRepository batchRepository) {
        this.inboundOrderRepository = inboundOrderRepository;
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
        this.agentRepository = agentRepository;
        this.userRepository = userRepository;
        this.sectionRepository = sectionRepository;
        this.batchRepository = batchRepository;
    }


    @Override
    public ResponseEntity<InboundOrderResponseDTO> saveInboundOrder(InboundOrderRequestDTO inboundOrderRequest, String username) {

        List<BatchStockDTO> batchesInList = inboundOrderRequest.getInbound_order().getBatch_stock();

        // Validar que exista el producto en la base
        for (BatchStockDTO batchStockDTO : batchesInList) {
            if(batchStockDTO.getCurrentQuantity() != batchStockDTO.getInitialQuantity())
                throw new BatchCurrentQuantityIsDifferentFromInitialQuantityException(batchStockDTO.getProductId());
        }

        Long warehouseCode = inboundOrderRequest.getInbound_order().getSection().getWarehouse_code();
        Warehouse warehouse = warehouseRepository.findById(warehouseCode).get();

        Long sectionCode = inboundOrderRequest.getInbound_order().getSection().getSection_code();
        Section section = sectionRepository.findById(sectionCode).get();

        User user = userRepository.findByUsername(username).get();
        Agent agent = agentRepository.findByUser(user).get();



        validateInboundOrderData(inboundOrderRequest, warehouse, section, agent);

        // Crear inbound order
        List<Batch> batchList = inboundOrderRequest.getInbound_order().getBatch_stock()
                                .stream()
                                .map(x -> new Batch(x, productRepository.findById(x.getProductId()).get()))
                                .collect(Collectors.toList());

        InboundOrder inboundOrder = new InboundOrder(inboundOrderRequest.getInbound_order(), warehouse, section, agent);
        inboundOrderRepository.save(inboundOrder);
        batchRepository.saveAll(batchList);
        List<BatchStockDTO> batchCreatedList = batchList
                .stream()
                .map(x -> new BatchStockDTO(x))
                .collect(Collectors.toList());

        return new ResponseEntity<>(new InboundOrderResponseDTO(batchCreatedList), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<InboundOrderResponseDTO> updateInboundOrder(InboundOrderRequestDTO inboundOrderRequest, String username) {

        Long inboundId = inboundOrderRequest.getInbound_order().getId();
        InboundOrder inboundOrder = inboundOrderRepository.findById(inboundId)
                .orElseThrow(()-> new InvalidInboundOrderException(inboundId));

        List<BatchStockDTO> batchesInList = inboundOrderRequest.getInbound_order().getBatch_stock();

        for (BatchStockDTO batchStockDTO : batchesInList) {
            batchRepository.findByIdAndInboundOrder(batchStockDTO.getId(), inboundOrder)
                    .orElseThrow(() -> new InvalidBatchException(batchStockDTO.getId()));
        }

        Long warehouseCode = inboundOrderRequest.getInbound_order().getSection().getWarehouse_code();
        Warehouse warehouse = warehouseRepository.findById(warehouseCode).get();

        Long sectionCode = inboundOrderRequest.getInbound_order().getSection().getSection_code();
        Section section = sectionRepository.findById(sectionCode).get();

        User user = userRepository.findByUsername(username).get();
        Agent agent = agentRepository.findByUser(user).get();

        validateInboundOrderData(inboundOrderRequest, warehouse, section, agent);

        for (BatchStockDTO batchStockDTO : batchesInList) {
            Batch batch = batchRepository.findById(batchStockDTO.getId()).get();
            batch.setCurrentQuantity(batchStockDTO.getCurrentQuantity());
            batch.setCurrentTemperature(batchStockDTO.getCurrentTemperature());
            batch.setManufacturingTime(batchStockDTO.getManufacturingTime());
            batch.setDueDate(batchStockDTO.getDueDate());
            batchRepository.save(batch);
        }

        List<Batch> batchList = batchesInList
                .stream()
                .map(x -> new Batch(x, productRepository.findById(x.getProductId()).get()))
                .collect(Collectors.toList());

        List<BatchStockDTO> batchCreatedList = batchList
                .stream()
                .map(x -> new BatchStockDTO(x))
                .collect(Collectors.toList());

        return new ResponseEntity<>(new InboundOrderResponseDTO(batchCreatedList), HttpStatus.CREATED);
    }

    private void validateInboundOrderData(InboundOrderRequestDTO inboundOrderRequest, Warehouse warehouse, Section section, Agent agent){

        List<BatchStockDTO> batchesInList = inboundOrderRequest.getInbound_order().getBatch_stock();

        // Validar que exista el producto en la base
        for (BatchStockDTO batchStockDTO : batchesInList) {
            Product product = productRepository.findById(batchStockDTO.getProductId())
                    .orElseThrow(() -> new InvalidProductException(batchStockDTO.getProductId()));

            if(batchStockDTO.getCurrentQuantity() > batchStockDTO.getInitialQuantity())
                throw new BatchCurrentQuantityBiggerThanInitialQuantityException(batchStockDTO.getProductId());

            if(!product.getCategory().equals(section.getCategory()))
                throw new ProductCategoryIsDifferentFromSectionCategoryException(product, section);
        }

        // Validar que exista el warehouse en la base
        warehouseRepository.findById(warehouse.getId())
                .orElseThrow(() -> new InvalidWarehouseException(warehouse.getId()));

        // Validar que el agent pertenezca al warehouse
        // El Id del Agent lo tenemos que obtener del token de JWT
        warehouseRepository.findByIdAndAgent(warehouse.getId(), agent)
                .orElseThrow(()-> new AgentDoesNotBelongToWarehouseException(agent.getId(), warehouse.getId()));

        // Validar que exista el sector en la base
        sectionRepository.findById(section.getId())
                .orElseThrow(()-> new InvalidSectionException(section.getId()));

        // Validar que el sector pertenezca al producto
        for (BatchStockDTO batchStockDTO : batchesInList) {
            if(batchStockDTO.getMinimumTemperature() > batchStockDTO.getCurrentTemperature())
                throw new BatchMinTempBiggerThanCurrentTempException(batchStockDTO.getProductId());

            if ((section.getMinimumTemperature() > batchStockDTO.getMinimumTemperature()) || (section.getMaximumTemperature() < batchStockDTO.getCurrentTemperature()))
                throw new BatchTempOutsideSectionTempRangeException(batchStockDTO.getProductId(), section.getMinimumTemperature(), section.getMaximumTemperature());
        }

        // Validar que el sector tenga espacio disponible
        List<InboundOrder> inboundOrdersList = inboundOrderRepository.findByWarehouseAndSection(warehouse, section);
        Integer countBatches = 0;
        for(InboundOrder io : inboundOrdersList){
            List<Batch> batches = batchRepository.findByInboundOrder(io);
            countBatches+= batches.size();
        }
        Integer availableQuantity = section.getMaxQuantityBatch() - countBatches;
        if(availableQuantity < inboundOrderRequest.getInbound_order().getBatch_stock().size())
            throw new QuantityNotAvailableException(section.getId());

    }
}
