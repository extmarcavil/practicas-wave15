package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResPostTestDto save(ReqTestCaseDto test);
    List<TestCase> getAll();
    TestCase getById(Long id);
    ResPostTestDto update(Long id, ReqTestCaseDto test);
    String deleteById(Long id);
    List<TestCase> searchByDate(LocalDate lastUpdate);
}
