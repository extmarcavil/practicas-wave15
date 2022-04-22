package com.apiconcesionarioautos.controller;

import com.apiconcesionarioautos.dto.request.VehicleRequestDTO;
import com.apiconcesionarioautos.dto.response.VehicleResponseDTO;
import com.apiconcesionarioautos.dto.response.VehicleResponseDetailDTO;
import com.apiconcesionarioautos.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    //region Variables
    private IVehicleService _vehicleService;
    //endregion

    //region Constructor

    public VehicleController(IVehicleService vehicleService) {
        this._vehicleService = vehicleService;
    }

    //endregion

    //region end points
    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles(){
        return  new ResponseEntity<>(_vehicleService.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/prices/{priceStart}/{priceEnd}")
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesRangePrice(@PathVariable double priceStart,@PathVariable double priceEnd){
        return  new ResponseEntity<>(_vehicleService.getVehiclesRangePrice(priceStart,priceEnd), HttpStatus.OK);
    }

    @GetMapping("/dates/{dateStart}/{dateEnd}")
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesRangeDateManufaturing(@PathVariable String dateStart, @PathVariable String dateEnd) throws ParseException {
        var date1= new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
        var date2= new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
        return  new ResponseEntity<>(_vehicleService.getVehiclesRangeDateManufaturing(date1,date2), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDetailDTO> getVehicleById(@PathVariable int id){
        return  new ResponseEntity<>(_vehicleService.getInfoVehicle(id), HttpStatus.OK);
    }

    @PostMapping
    public boolean AddVehicle(@RequestBody VehicleRequestDTO vehicleRequest){
        return _vehicleService.addVehicle(vehicleRequest);
    }
    //endregion
}
