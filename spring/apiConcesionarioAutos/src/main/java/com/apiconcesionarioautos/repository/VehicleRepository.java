package com.apiconcesionarioautos.repository;

import com.apiconcesionarioautos.model.Vehicle;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository  implements  IVehicleRepository{

    //region Variables
    private List<Vehicle> listVehicles;
    //endregion

    //region Constructor

    public VehicleRepository() {
        listVehicles = new ArrayList<>();
    }

    //endregion

    //region Implementacion

    @Override
    public boolean add(Vehicle vehicle) {
        vehicle.setId(newId());
        listVehicles.add(vehicle);
        return true;
    }

    @Override
    public List<Vehicle> getAll() {
        return listVehicles;
    }

    @Override
    public List<Vehicle> getDateManufaturingRange(Date dateManufaturingStart,Date dateManufaturingEnd) {
        return listVehicles.stream()
                            .filter(f ->
                                f.getManufaturingDate().after(dateManufaturingStart) &&
                                f.getManufaturingDate().before(dateManufaturingEnd)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getPriceRange(double priceStart, double priceEnd) {
        return  listVehicles.stream()
                .filter(f ->
                        f.getPrice() >= priceStart && f.getPrice() <= priceEnd)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle getInfoById(int Id) {
       return getAll().stream().filter(f ->
                f.getId() == Id)
                .findFirst()
                .orElse(null);
    }

    //endregion

    //region privados
    private int newId(){
        return  listVehicles.size() <= 0 ? 1 : listVehicles.get(listVehicles.size() - 1).getId() + 1;
    }

    //endregion
}
