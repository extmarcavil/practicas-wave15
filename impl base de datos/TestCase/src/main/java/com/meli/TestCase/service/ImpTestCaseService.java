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
public class ImpTestCaseService implements ITestCaseService {
    private ITestCaseRespository repo;

    public ImpTestCaseService(ITestCaseRespository repo) {
        this.repo = repo;
    }

    @Override
    public ResPostTestDto guardar(ReqTestCaseDto test) {
        TestCase t = new TestCase(test.getDesc(),
                test.isTested(),
                test.isPassed(),
                test.getNumber_of_tries(),
                test.getLastUpdate());
        repo.save(t);

        ResPostTestDto respuesta = new ResPostTestDto(t.getDescription(),
                t.isTested(), t.isPassed(), t.getNumber_of_tries(), t.getLastUpdate(), "todo ok");

        return respuesta;
    }

    @Override
    public List<TestCase> obtenerTodos(String last_update) {
        // si no existe el filtro devuelve todos
        if (last_update.equals("")) return repo.findAll();

        String[] dates = last_update.split("-");

        LocalDate date = LocalDate.of(
                Integer.parseInt(dates[2]),
                Integer.parseInt(dates[1]),
                Integer.parseInt(dates[0]));

        List<TestCase> respuesta = repo
                .findAll()
                .stream()
                .filter(t -> t.getLastUpdate().isAfter(date))
                .collect(Collectors.toList());

        return respuesta;
    }

    @Override
    public TestCase obtenerPorId(Long id) {
        TestCase test = repo.findById(id).orElseThrow(() -> new RuntimeException());
        return test;
    }

    @Override
    public ResPostTestDto updateCase(Long id, ReqTestCaseDto test) {
        TestCase testEntity = repo.getById(id);

        testEntity.setDescription(test.getDesc());
        testEntity.setTested(test.isTested());
        testEntity.setPassed(test.isPassed());
        testEntity.setNumber_of_tries(test.getNumber_of_tries());
        testEntity.setLastUpdate(test.getLastUpdate());

        repo.save(testEntity);

        ResPostTestDto respuesta = new ResPostTestDto(
                testEntity.getDescription(),
                testEntity.isTested(),
                testEntity.isPassed(),
                testEntity.getNumber_of_tries(),
                testEntity.getLastUpdate(),
                "todo ok");

        return respuesta;
    }

    @Override
    public String deleteCase(Long id) {
        repo.deleteById(id);

        return "Caso borrado con exito";
    }

}
