package com.example.demo.dto;

import com.example.demo.model.Jewel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JewelListDTO {

    List<Jewel> jewels;
}
