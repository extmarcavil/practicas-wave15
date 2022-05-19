package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public String delete(Long id) {
        try {
            repo.deleteById(id);
            return "Se borro el id " + id;
        } catch(EmptyResultDataAccessException e) {
            return "No existe el id " + id;
        }
    }

    @Override
    public ResPostTestDto update(Long id, ReqTestCaseDto test) {
        TestCase t = this.obtenerPorId(id);

        // asi con todos
        if (test.getDesc() != null)
            t.setDescription(test.getDesc());

        t.setLastUpdate(test.getLastUpdate());
        t.setTested(test.isTested());
        t.setPassed(test.isPassed());
        t.setNumber_of_tries(test.getNumber_of_tries());

        t = repo.save(t);

        ResPostTestDto respuesta = new ResPostTestDto(t.getDescription(),
                t.isTested(),t.isPassed(),t.getNumber_of_tries(),t.getLastUpdate(),"objeto actualizado");

        return respuesta;
    }

    @Override
    public List<TestCase> searchByDate(LocalDate fecha) {
        return repo.findAllByLastUpdateAfter(fecha);
    }

}
