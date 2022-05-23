package com.bootcamp.consecionariahql.Service.interfaces;

import com.bootcamp.consecionariahql.Model.DTO.Crash.CrashDTO;
import com.bootcamp.consecionariahql.Model.DTO.Crash.CrashResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ICrashService {

    public CrashResponseDTO save(CrashDTO crashDTO);
}
