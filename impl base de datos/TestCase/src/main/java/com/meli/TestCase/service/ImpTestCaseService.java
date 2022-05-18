package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpTestCaseService implements ITestCaseService {

    private final ITestCaseRespository repo;
    ModelMapper mapper = new ModelMapper();

    public ImpTestCaseService(ITestCaseRespository repo) {
        this.repo = repo;
    }

    @Override
    public ResPostTestDto guardar(ReqTestCaseDto test){
        TestCase t = mapper.map(test, TestCase.class);
        ResPostTestDto response = mapper.map(repo.save(t), ResPostTestDto.class);
        response.setMensaje("todo ok");

        return response;
    }
    @Override
    public List<TestCase> obtenerTodos(){
        return repo.findAll();
    }

    @Override
    public TestCase obtenerPorId(Long id){
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public TestCase actualizar(Long id, ReqTestCaseDto test) {
        TestCase model = repo.findById(id).orElseThrow(RuntimeException::new);
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
    public List<TestCase> obtenerPorFecha(LocalDate date) {
            return  repo.findAll().stream()
                    .filter(f -> f.getLastUpdate().isAfter(date))
                        .collect(Collectors.toList());
    }
}
