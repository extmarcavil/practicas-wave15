package com.meli.convert.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ConvertService {

    String convertMorseCode(String[] codes);
}
