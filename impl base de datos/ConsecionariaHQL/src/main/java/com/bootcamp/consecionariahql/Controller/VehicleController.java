package com.bootcamp.consecionariahql.Controller;

import com.bootcamp.consecionariahql.Model.DTO.Vehicle.VehicleDTO;
import com.bootcamp.consecionariahql.Service.Impl.CrashService;
import com.bootcamp.consecionariahql.Service.Impl.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;
    private final CrashService crashService;

    public VehicleController(VehicleService service, CrashService crashService) {
        this.vehicleService = service;
        this.crashService = crashService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VehicleDTO vehicleDTO) {
        return new ResponseEntity<VehicleDTO>(vehicleService.create(vehicleDTO), HttpStatus.OK);
    }
}


