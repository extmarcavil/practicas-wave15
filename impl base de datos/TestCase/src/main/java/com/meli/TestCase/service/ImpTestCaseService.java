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
    public ResPostTestDto save(ReqTestCaseDto test){
        TestCase t = new TestCase(test.getDesc(),
                test.isTested(),
                test.isPassed(),
                test.getNumber_of_tries(),
                test.getLastUpdate());
        repo.save(t);

        ResPostTestDto respuesta = new ResPostTestDto(t.getDescription(),
                t.isTested(),t.isPassed(),t.getNumber_of_tries(),t.getLastUpdate(),
                "Alta exitosa.");

        return respuesta;
    }
    @Override
    public List<TestCase> getAll(){
        List<TestCase> respuesta = repo.findAll();
        return respuesta;
    }
    @Override
    public TestCase getById(Long id){
        TestCase test = repo.findById(id).orElseThrow(()->new RuntimeException());
        return test;
    }

    @Override
    public ResPostTestDto update(Long id, ReqTestCaseDto test) {
        TestCase testToUpdate = repo.findById(id).orElseThrow(()->new RuntimeException());

        testToUpdate.setDescription(test.getDesc());
        testToUpdate.setTested(test.isTested());
        testToUpdate.setPassed(test.isPassed());
        testToUpdate.setNumber_of_tries(test.getNumber_of_tries());
        testToUpdate.setLastUpdate(test.getLastUpdate());

        repo.save(testToUpdate);

        ResPostTestDto respuesta = new ResPostTestDto(testToUpdate.getDescription(), testToUpdate.isTested(),
                testToUpdate.isPassed(), testToUpdate.getNumber_of_tries(),testToUpdate.getLastUpdate(),
                "Modificación exitosa.");

        return respuesta;
    }

    @Override
    public String deleteById(Long id) {
        repo.deleteById(id);

        return "Baja exitosa.";
    }

    @Override
    public List<TestCase> searchByDate(LocalDate lastUpdate) {
        //Método que se puede generar en el repo a partir de un template y teniendo en cuenta los campos de la tabla.
        return repo.findAllByLastUpdateAfter(lastUpdate);
    }

}
