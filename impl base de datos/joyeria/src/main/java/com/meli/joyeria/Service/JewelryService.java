package com.meli.joyeria.Service;

import com.meli.joyeria.Model.Jewelry;
import com.meli.joyeria.Repository.IJewelryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryService implements IJewelryService{

    // data
    IJewelryRepository repository;

    // constructors
    public JewelryService(IJewelryRepository repository) {
        this.repository = repository;
    }

    // methods
    public List<Jewelry> getJewelry () {
        return repository.findAll();
    }

    public Jewelry findJewelry (long id) {
        return repository.findById(id).orElse(null);
    }

    public Jewelry saveJewelry (Jewelry jewelry) {
        repository.save(jewelry);
        return jewelry;
    }

    public List<Jewelry> deleteJewelry (Long id) {
        repository.deleteById(id);
        return getJewelry();
    }

}
