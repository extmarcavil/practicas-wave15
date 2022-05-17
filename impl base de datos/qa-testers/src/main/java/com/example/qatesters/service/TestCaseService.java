package com.example.qatesters.service;

import com.example.qatesters.api.dto.IdCaseDto;
import com.example.qatesters.api.dto.TestCaseDto;
import com.example.qatesters.api.mapper.TestCaseMapper;
import com.example.qatesters.model.TestCase;
import com.example.qatesters.repository.TestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TestCaseService {

    private final TestCaseRepository repository;
    private final TestCaseMapper mapper;


    public IdCaseDto create(TestCaseDto test) {
        TestCase testCase = mapper.testCaseDtoToTestCase(test);
        return mapper.testCaseToIdCase(repository.save(testCase));
    }

    public List<TestCaseDto> findAll(LocalDate date) {
        Stream<TestCase> stream;

        if (date == null)  stream = repository.findAll().stream();
        else stream = repository.findAllByLastUpdateAfter(date).stream();

        return stream
                .map(testCase -> mapper.testCaseToTestCaseDto(testCase))
                .collect(Collectors.toList());
    }

    private TestCase getTestCase(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("hola"));

    }
    public TestCaseDto findById(Long id) {
        return mapper.testCaseToTestCaseDto(getTestCase(id));
    }

    @Transactional
    public TestCaseDto update(Long id, TestCaseDto test) {
        TestCase testCase = getTestCase(id);
        mapper.updateTestCaseFromTestCaseDto(test,testCase);
        return mapper.testCaseToTestCaseDto(repository.save(testCase));
    }

    @Transactional
    public void delete(Long id) {
        TestCase testCase = getTestCase(id);
        repository.delete(testCase);
    }
}
