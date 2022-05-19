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
public class ImpTestCaseService implements ITestCaseService {
    private final ITestCaseRespository repo;

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

        return new ResPostTestDto(t.getDescription(),
                t.isTested(), t.isPassed(), t.getNumber_of_tries(), t.getLastUpdate(), "todo ok");
    }

    @Override
    public List<TestCase> obtenerTodos(LocalDate last_update) {
        return repo.findAll();
    }

    @Override
    public TestCase obtenerPorId(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    @Override
    public Boolean cambiarEstado(Long id) {
        repo.updateInfoById(id);
        return true;
    }

    @Override
    public Boolean eliminar(Long id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public List<TestCase> obtenerTodosPorFecha(LocalDate lastUpdate) {
        return repo.findAllByLastUpdateAfter(lastUpdate);
    }

}
