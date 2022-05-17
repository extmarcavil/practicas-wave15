package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResPostTestDto guardar(ReqTestCaseDto test);
    List<TestCase> obtenerTodos(LocalDate last_update);
    TestCase obtenerPorId(Long id);

    Boolean cambiarEstado(Long id);

    Boolean eliminar(Long id);
}
