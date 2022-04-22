package com.apiconcesionarioautos.repository;

import com.apiconcesionarioautos.model.Vehicle;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface IVehicleRepository {
    List<Vehicle> getAll();

    List<Vehicle> getDateManufaturingRange(Date dateManufaturingStart,Date dateManufaturingEnd);

    List<Vehicle> getPriceRange(double priceStart,double priceEnd);

    Vehicle getInfoById(int Id);

    boolean add(Vehicle vehicle);

}
