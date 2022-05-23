package com.bootcamp.consecionariahql.Repository;

import com.bootcamp.consecionariahql.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IVehicleRepo extends JpaRepository<Vehicle, Long> {

}
