package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestDto;
import com.meli.TestCase.Dto.ResTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{

    private final ITestCaseRespository repository;
    private final ModelMapper mapper;

    public TestCaseService(ITestCaseRespository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    @Override
    @Transactional
    public ResTestDto saveTest(ReqTestDto test){
        TestCase t = mapper.map(test, TestCase.class);
        repository.save(t);

        return mapper.map(t, ResTestDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResTestDto> getTests(LocalDate lastUpdate){
        List<TestCase> tests;

        if (lastUpdate == null){
            tests = repository.findAll();
        } else {
            tests = repository.findAllByLastUpdateAfter(lastUpdate);
        }

        return tests.stream().map(v -> mapper.map(v, ResTestDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ResTestDto getTestById(Long id){
        TestCase test = repository.findById(id).orElseThrow(RuntimeException::new);

        return mapper.map(test, ResTestDto.class);
    }

    @Override
    @Transactional
    public ResTestDto updateTest(Long id, ReqTestDto newData) {
        TestCase test = repository.findById(id).orElseThrow(RuntimeException::new);

        test.setDescription(newData.getDescription());
        test.setTested(newData.isTested());
        test.setPassed(newData.isPassed());
        test.setLastUpdate(newData.getLastUpdate());
        test.setNumberOfTries(newData.getNumberOfTries());
        repository.save(test);

        return this.getTestById(id);
    }

    @Override
    @Transactional
    public Long deleteTest(Long id) {
        repository.deleteById(id);

        return id;
    }
}
