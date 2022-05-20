package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;

import java.util.List;

public interface ITestCaseService {
    ResPostTestDto guardar(ReqTestCaseDto test);
    List<TestCase> obtenerTodos(String aPartirDeFecha);
    TestCase obtenerPorId(Long id);
    ResPostTestDto actualizarPorId(Long id, ReqTestCaseDto test);
    void eliminarPorId(Long id);
}
