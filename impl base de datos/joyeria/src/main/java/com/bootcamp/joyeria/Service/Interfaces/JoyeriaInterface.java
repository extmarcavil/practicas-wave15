package com.bootcamp.joyeria.Service.Interfaces;

import com.bootcamp.joyeria.Dto.Request.JoyaRequestDTO;
import com.bootcamp.joyeria.Model.Joya;

import java.util.List;

public interface JoyeriaInterface {
    public void guardarJoya(JoyaRequestDTO joya);
    public void actualizarJoya(Long id, JoyaRequestDTO joyaRequestDTO);
    public void eliminarJoya(Long id);
    public Joya buscarJoya(Long id);
    public List<Joya> listarJoyas();

    public List<JoyaRequestDTO> listarJoyasVendidas();

}
