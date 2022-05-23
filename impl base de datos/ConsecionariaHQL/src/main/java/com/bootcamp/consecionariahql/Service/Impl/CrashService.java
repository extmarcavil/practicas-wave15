package com.bootcamp.consecionariahql.Service.Impl;

import com.bootcamp.consecionariahql.Model.Crash;
import com.bootcamp.consecionariahql.Model.DTO.Crash.CrashDTO;
import com.bootcamp.consecionariahql.Model.DTO.Crash.CrashResponseDTO;
import com.bootcamp.consecionariahql.Repository.ICrashRepo;
import com.bootcamp.consecionariahql.Service.interfaces.ICrashService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CrashService implements ICrashService {

    private final ICrashRepo crashRepo;

    private final ModelMapper mapper;

    public CrashService(ICrashRepo crashRepo, ModelMapper mapper) {
        this.crashRepo = crashRepo;
        this.mapper = mapper;
    }

    @Override
    public CrashResponseDTO save(CrashDTO crashDTO) {
        Crash crash = mapper.map(crashDTO, Crash.class);
        if(crashRepo.save(crash) != null){
            return new CrashResponseDTO("Accident registred successfully");
        }else {
            return new CrashResponseDTO("Error in the registration of the accident");
        }
    }
}
