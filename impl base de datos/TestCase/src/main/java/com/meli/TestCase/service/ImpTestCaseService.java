package com.meli.TestCase.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ImpTestCaseService implements ITestCaseService{
    private ITestCaseRespository repo;

    public ImpTestCaseService(ITestCaseRespository repo) {
        this.repo = repo;
    }

    @Override
    public ResPostTestDto guardar(ReqTestCaseDto test){
        TestCase t = new TestCase(test.getDesc(),
                test.isTested(),
                test.isPassed(),
                test.getNumber_of_tries(),
                test.getLastUpdate());
        repo.save(t);

        ResPostTestDto respuesta = new ResPostTestDto(t.getDescription(),
                t.isTested(),t.isPassed(),t.getNumber_of_tries(),t.getLastUpdate(),"todo ok");

        return respuesta;
    }
    @Override
    public List<TestCase> obtenerTodos(){
        List<TestCase> respuesta = repo.findAll();
        return respuesta;
    }
    @Override
    public TestCase obtenerPorId(Long id){
        TestCase test = repo.findById(id).orElseThrow(()->new RuntimeException());
        return test;
    }

    @Override
    public List<TestCase>  obtenerPorFecha(String lastUpdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(lastUpdate, formatter);
        List<TestCase> tests = repo.findByLastUpdateAfter(fecha);
        return tests;
    }

    @Override
    public String updateTest(Long id, ReqTestCaseDto test) {
        TestCase testCase = this.obtenerPorId(id);

        testCase.setLastUpdate(test.getLastUpdate());
        testCase.setTested(test.isTested());
        testCase.setPassed(test.isPassed());
        testCase.setDescription(test.getDesc());
        testCase.setNumber_of_tries(test.getNumber_of_tries());

        repo.save(testCase);
        return "Acualizado correctamente";
    }

    @Override
    public String deleteTest(Long id) {
        repo.deleteById(id);
        return "Test eliminado correctamente";
    }

}
