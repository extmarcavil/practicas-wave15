package com.meli.TestCase.service;

import com.meli.TestCase.dto.ReqTestCaseDto;
import com.meli.TestCase.dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public TestCase actualizarPorId(ReqTestCaseDto testCase, Long id) {
        TestCase test = obtenerPorId(id);

        test.setDescription(testCase.getDesc());
        test.setNumber_of_tries(testCase.getNumber_of_tries());
        test.setLastUpdate(testCase.getLastUpdate());
        test.setPassed(testCase.isPassed());
        test.setTested(testCase.isTested());
        repo.save(test);
        return test;
    }

    @Override
    public void borrarPorId(Long id) {
        TestCase test = obtenerPorId(id);
        repo.delete(test);

    }

    @Override
    public List<TestCase> buscarPorFecha(LocalDate localDate) {
        return repo.findAllByLastUpdateAfter(localDate);
    }

}
