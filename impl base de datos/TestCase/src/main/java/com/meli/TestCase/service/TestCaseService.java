package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestDto;
import com.meli.TestCase.Dto.ResTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public ResTestDto saveTest(ReqTestDto test){
        TestCase t = mapper.map(test, TestCase.class);
        repository.save(t);

        return mapper.map(t, ResTestDto.class);
    }

    @Override
    public List<ResTestDto> getTests(String lastUpdate){
        List<TestCase> tests = repository.findAll();

        if (lastUpdate != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(lastUpdate, formatter);
            tests = tests.stream().filter(v -> v.getLastUpdate().isAfter(date)).collect(Collectors.toList());
        }

        return tests.stream().map(v -> mapper.map(v, ResTestDto.class)).collect(Collectors.toList());
    }

    @Override
    public ResTestDto getTestById(Long id){
        TestCase test = repository.findById(id).orElseThrow(RuntimeException::new);

        return mapper.map(test, ResTestDto.class);
    }

    @Override
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
    public Long deleteTest(Long id) {
        repository.deleteById(id);

        return id;
    }
}
