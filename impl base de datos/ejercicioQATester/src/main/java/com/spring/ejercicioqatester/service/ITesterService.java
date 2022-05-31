package com.spring.ejercicioqatester.service;

import com.spring.ejercicioqatester.dto.request.ReqTestCaseDTO;
import com.spring.ejercicioqatester.dto.response.RespTestCaseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITesterService {
    public RespTestCaseDTO saveTestCase(ReqTestCaseDTO testCaseDTO);

    public List<RespTestCaseDTO> getAllTest();

    public RespTestCaseDTO getTestById(Long id);

    public RespTestCaseDTO updateTest(Long id, ReqTestCaseDTO testCaseDTO);
}
