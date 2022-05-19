package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpTestCaseService implements ITestCaseService{
    private final ITestCaseRespository repo;

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
    public ResPostTestDto editar(Long id, boolean test_passed){
        TestCase t = repo.findById(id).orElse(null);
        t.setPassed(test_passed);
        repo.save(t);

        return new ResPostTestDto(t.getDescription(),
                t.isTested(),t.isPassed(),t.getNumber_of_tries(),t.getLastUpdate(),"todo ok");
    }

    @Override
    public String eliminar(Long id){
        repo.deleteById(id);
        return "Se elimino el test con id: " + id + ".";
    }

    @Override
    public List<TestCase> obtenerTodosPorFecha(String last_update){
        LocalDate fecha = LocalDate.parse(last_update);
        return repo.findAll().stream().filter(t -> t.getLastUpdate().isAfter(fecha)).collect(Collectors.toList());
    }

}
