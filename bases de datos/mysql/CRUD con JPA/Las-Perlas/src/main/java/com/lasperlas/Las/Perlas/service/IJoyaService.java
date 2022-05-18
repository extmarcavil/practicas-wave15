package com.lasperlas.Las.Perlas.service;

import com.lasperlas.Las.Perlas.dto.requestDTO.RequestJoyaDTO;
import com.lasperlas.Las.Perlas.dto.responseDTO.ResponseJoyaDTO;
import com.lasperlas.Las.Perlas.model.Joya;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IJoyaService {
    public List<ResponseJoyaDTO> getJoyas();

    public ResponseJoyaDTO saveJoya(RequestJoyaDTO joya);

    public void deleteJoya(Long id);

    public Joya findJoya(Long id);
}
