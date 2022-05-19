package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
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
    public ResPostTestDto update(Long id, ReqTestCaseDto test) {
        TestCase newTest = this.obtenerPorId(id);

        newTest.setDescription(test.getDesc());
        newTest.setTested(test.isTested());
        newTest.setPassed(test.isPassed());
        newTest.setNumber_of_tries(test.getNumber_of_tries());
        newTest.setLastUpdate(test.getLastUpdate());

        repo.save(newTest);
        ResPostTestDto response = new ResPostTestDto(newTest.getDescription(), newTest.isTested(), newTest.isPassed(), newTest.getNumber_of_tries(), newTest.getLastUpdate(), "Actualizado correctamente.");

        return response;
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<TestCase> listByUpdateDate(LocalDate lastUpdate) {
        List<TestCase> response = repo.findAllByLastUpdateAfter(lastUpdate);
        return response;
    }

}
