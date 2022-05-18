package com.joyeriaP.joyeriaP.service;

import com.joyeriaP.joyeriaP.model.Jewelry;

import java.util.Collection;
import java.util.List;

public interface IJewelryService {

    Jewelry saveJewelry(Jewelry j);

    Collection<Jewelry> getAllJewelry();

    Jewelry deleteJewelry(Long id);

    Jewelry updateJewelry(Jewelry jewelry, Long id);


}
