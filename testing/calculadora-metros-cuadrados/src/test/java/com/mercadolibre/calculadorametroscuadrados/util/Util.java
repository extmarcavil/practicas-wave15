package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static HouseDTO houseDTO(){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setAddress("Carrera 9 # 7d 97");
        houseDTO.setName("Caldas");

        RoomDTO room1 = new RoomDTO();
        room1.setLength(30);
        room1.setWidth(30);
        room1.setName("Habitacion 1");

        RoomDTO room2 = new RoomDTO();
        room2.setLength(40);
        room2.setWidth(60);
        room2.setName("Habitacion 2");

        List<RoomDTO> roomDTOList = new ArrayList<>();
        roomDTOList.add(room1);
        roomDTOList.add(room2);

        houseDTO.setRooms(roomDTOList);
        return houseDTO;
    }

    public static HouseResponseDTO houseResponseDTO(){
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setAddress("Carrera 9 # 7d 97");
        houseResponseDTO.setName("Caldas");

        RoomDTO room1 = new RoomDTO();
        room1.setLength(30);
        room1.setWidth(30);
        room1.setName("Habitacion 1");

        RoomDTO room2 = new RoomDTO();
        room2.setLength(40);
        room2.setWidth(60);
        room2.setName("Habitacion 2");

        List<RoomDTO> roomDTOList = new ArrayList<>();
        roomDTOList.add(room1);
        roomDTOList.add(room2);
        houseResponseDTO.setRooms(roomDTOList);

        houseResponseDTO.setBiggest(room2);
        houseResponseDTO.setPrice(2640000);
        houseResponseDTO.setSquareFeet(2400+900);
        return houseResponseDTO;
    }
}
