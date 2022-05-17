package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResPostTestDto guardar(ReqTestCaseDto test);
    List<TestCase> obtenerTodos();
    TestCase obtenerPorId(Long id);

    ResPostTestDto actualizar(Long id, ReqTestCaseDto test);

    void eliminarPorId(Long id);

    List<TestCase> obtenerTodosPorFechaDeActualizacion(LocalDate lastUpdate);
}
