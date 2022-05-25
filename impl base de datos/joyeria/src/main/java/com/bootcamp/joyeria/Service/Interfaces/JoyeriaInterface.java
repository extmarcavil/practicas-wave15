package com.bootcamp.joyeria.Service.Interfaces;

import com.bootcamp.joyeria.Dto.Request.JoyaRequestDTO;
import com.bootcamp.joyeria.Dto.Response.JoyaResponseDTO;
import com.bootcamp.joyeria.Model.Joya;

import java.util.List;

public interface JoyeriaInterface {
    public Long guardarJoya(JoyaRequestDTO joya);
    public void actualizarJoya(Long id, JoyaRequestDTO joyaRequestDTO);
    public void eliminarJoya(Long id);
    public Joya buscarJoya(Long id);
    public List<JoyaResponseDTO> listarJoyas();

    public List<JoyaRequestDTO> listarJoyasVendidas();

}
