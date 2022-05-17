package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestDto;
import com.meli.TestCase.Dto.ResTestDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    ResTestDto saveTest(ReqTestDto test);

    List<ResTestDto> getTests(LocalDate lastUpdate);

    ResTestDto getTestById(Long id);

    ResTestDto updateTest(Long id, ReqTestDto newData);

    Long deleteTest(Long id);
}
