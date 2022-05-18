package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    public TestCase actualizar(Long id, ReqTestCaseDto test) {
        TestCase model = repo.findById(id).orElseThrow(()->new RuntimeException());
        model.setDescription(test.getDesc());
        model.setTested(test.isTested());
        model.setNumber_of_tries(test.getNumber_of_tries());
        model.setPassed(test.isPassed());
        model.setLastUpdate(test.getLastUpdate());
        return repo.save(model);
    }

    @Override
    public boolean eliminar(Long id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public List<TestCase> testxFecha(LocalDate lastUpdate) {
       return  repo.findAll().stream()
                .filter(f -> f.getLastUpdate().isAfter(lastUpdate)).collect(Collectors.toList());
    }
}
