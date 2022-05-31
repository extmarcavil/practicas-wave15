package com.spring.ejercicioqatester.service;

import com.spring.ejercicioqatester.dto.request.ReqTestCaseDTO;
import com.spring.ejercicioqatester.dto.response.RespTestCaseDTO;
import com.spring.ejercicioqatester.model.TestCase;
import com.spring.ejercicioqatester.repository.ITesterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TesterService implements ITesterService {

    private final ITesterRepository testerRepository;

    public TesterService(ITesterRepository testerRepository) {
        this.testerRepository = testerRepository;
    }


    @Override
    public RespTestCaseDTO saveTestCase(ReqTestCaseDTO testCaseDTO) {
        TestCase testCase = new TestCase(testCaseDTO.getDescription(),
                testCaseDTO.isTested(),
                testCaseDTO.isPassed(),
                testCaseDTO.getNumber_of_tries(),
                testCaseDTO.getLast_update());
        testerRepository.save(testCase);

        RespTestCaseDTO respTestCaseDTO = new RespTestCaseDTO(
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumber_of_tries(),
                testCase.getLast_update()
        );

        return respTestCaseDTO;
    }

    @Override
    public List<RespTestCaseDTO> getAllTest() {
        return testerRepository.findAll().stream()
                .map(testCase -> {
                    return new RespTestCaseDTO(
                            testCase.getDescription(),
                            testCase.getTested(),
                            testCase.getPassed(),
                            testCase.getNumber_of_tries(),
                            testCase.getLast_update()
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public RespTestCaseDTO getTestById(Long id) {
        TestCase testCase = testerRepository.findById(id).orElse(null);
        return new RespTestCaseDTO(
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumber_of_tries(),
                testCase.getLast_update()
        );
    }

    @Override
    public RespTestCaseDTO updateTest(Long id, ReqTestCaseDTO testCaseDTO) {
        TestCase testCase = testerRepository.findById(id).orElse(null);
        testCase.setDescription(testCaseDTO.getDescription());
        testCase.setTested(testCaseDTO.isTested());
        testCase.setPassed(testCaseDTO.isPassed());
        testCase.setNumber_of_tries(testCaseDTO.getNumber_of_tries());
        testCase.setLast_update(testCaseDTO.getLast_update());

        testerRepository.save(testCase);
        return getTestById(id);
    }
}
