package com.example.CrudConJPAJoyeriaLasPerlas.Service;

import com.example.CrudConJPAJoyeriaLasPerlas.Model.Joya;

import java.util.List;

public interface IJoyaService {
    public void saveJoya (Joya joya);
    public List<Joya> getJoyas ();
    public void deleteJoya (Integer id);
    public Joya findJoya (Integer id);
    public Joya updateJoya (Integer id, Joya joya);

}
