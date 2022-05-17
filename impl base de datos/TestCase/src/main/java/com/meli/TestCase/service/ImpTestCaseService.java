package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ImpTestCaseService implements ITestCaseService{
    private ITestCaseRespository repo;

    public ImpTestCaseService(ITestCaseRespository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
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
    @Transactional( readOnly = true)
    public List<TestCase> obtenerTodos(){
        List<TestCase> respuesta = repo.findAll();
        return respuesta;
    }
    @Override
    @Transactional( readOnly = true)
    public TestCase obtenerPorId(Long id){
        TestCase test = repo.findById(id).orElseThrow(()->new RuntimeException());
        return test;
    }

    @Override
    @Transactional
    public ResPostTestDto actualizar(Long id, ReqTestCaseDto test) {
        TestCase testUpdate = this.obtenerPorId(id);
        testUpdate.setDescription(test.getDesc());
        testUpdate.setTested(test.isTested());
        testUpdate.setPassed(test.isPassed());
        testUpdate.setNumber_of_tries(test.getNumber_of_tries());
        testUpdate.setLastUpdate(test.getLastUpdate());

        repo.save(testUpdate);
        ResPostTestDto respuesta = new ResPostTestDto(testUpdate.getDescription(),
                testUpdate.isTested(),testUpdate.isPassed(),testUpdate.getNumber_of_tries(),testUpdate.getLastUpdate(),"todo ok");

        return respuesta;

    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional( readOnly = true)
    public List<TestCase> obtenerTodosPorFechaDeActualizacion(LocalDate lastUpdate) {
        List<TestCase> respuesta = repo.findAllByLastUpdateAfter(lastUpdate);
        return respuesta;
    }

}
