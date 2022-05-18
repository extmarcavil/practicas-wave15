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
    public ResPostTestDto update(Long id, ReqTestCaseDto dto) {
        TestCase testTemp = this.obtenerPorId(id);

        if(dto.getDesc() != null){
            testTemp.setDescription(dto.getDesc());
        }
        if(dto.isTested() != testTemp.isTested()){
            testTemp.setTested(dto.isTested());
        }
        if(dto.isPassed() != testTemp.isPassed()){
            testTemp.setPassed(dto.isPassed());
        }
        if(dto.getNumber_of_tries() != testTemp.getNumber_of_tries()){
            testTemp.setNumber_of_tries(dto.getNumber_of_tries());
        }
        if(dto.getLastUpdate() != null){
            testTemp.setLastUpdate(dto.getLastUpdate());
        }

        testTemp = repo.save(testTemp);

        ResPostTestDto testDto = new ResPostTestDto(testTemp.getDescription(), testTemp.isTested(),
                testTemp.isPassed(), testTemp.getNumber_of_tries(), testTemp.getLastUpdate(), "todo ok");

        return testDto;
    }

    @Override
    public List<TestCase> searchByDate(LocalDate fecha) {
        return null;
    }

    @Override
    public ResPostTestDto delete(Long id) {
            repo.deleteById(id);
        return null;
    }


}
