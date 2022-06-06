package com.meli.joyeria.Service;

import com.meli.joyeria.Model.Jewelry;

import java.util.List;

public interface IJewelryService {
    public List<Jewelry> getJewelry();
    public Jewelry saveJewelry (Jewelry jewelry);
    public List<Jewelry> deleteJewelry (Long id);
    public Jewelry findJewelry (long id);
}
