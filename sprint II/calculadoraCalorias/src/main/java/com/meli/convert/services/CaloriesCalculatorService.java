package com.meli.convert.services;

import com.meli.convert.dto.MeatInfoRsDTO;
import org.springframework.stereotype.Service;

@Service
public interface CaloriesCalculatorService {

    MeatInfoRsDTO getMeatInfo(String name, Double grams);
}
