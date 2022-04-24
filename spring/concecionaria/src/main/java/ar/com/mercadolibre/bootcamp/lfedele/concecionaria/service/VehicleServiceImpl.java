package ar.com.mercadolibre.bootcamp.lfedele.concecionaria.service;

import ar.com.mercadolibre.bootcamp.lfedele.concecionaria.dto.VehicleDto;
import ar.com.mercadolibre.bootcamp.lfedele.concecionaria.model.Vehicle;
import ar.com.mercadolibre.bootcamp.lfedele.concecionaria.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ModelMapper mapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<VehicleDto> findAll() {
        return vehicleRepository
                .findAll()
                .stream()
                .map(v -> mapper.map(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto save(VehicleDto vehicleDto) {
        Vehicle model = mapper.map(vehicleDto, Vehicle.class);
        return mapper.map(vehicleRepository.save(model), VehicleDto.class);
    }

    @Override
    public Optional<VehicleDto> findById(Long id) {
        return vehicleRepository
                .findById(id)
                .map(v -> mapper.map(v, VehicleDto.class));
    }

    @Override
    public List<VehicleDto> findByPrice(Integer since, Integer to) {
        return vehicleRepository
                .findAll()
                .stream()
                .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
                .map(v -> mapper.map(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    private LocalDate toDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}
