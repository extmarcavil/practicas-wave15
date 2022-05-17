package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpTestCaseService implements ITestCaseService{
    ModelMapper mapper = new ModelMapper();
    private ITestCaseRespository repo;

    public ImpTestCaseService(ITestCaseRespository repo) {
        this.repo = repo;
    }

    @Override
    public ResPostTestDto guardar(ReqTestCaseDto test){
        TestCase t = new TestCase(test.getDescription(),
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
    public ResPostTestDto actualizar(Long id_actualizar, ReqTestCaseDto test) {
        TestCase testOriginal = repo.findById(id_actualizar).orElseThrow(()-> new RuntimeException());
        testOriginal.setDescription(test.getDescription());
        testOriginal.setTested(test.isTested());
        testOriginal.setPassed(test.isPassed());
        testOriginal.setNumber_of_tries(test.getNumber_of_tries());
        testOriginal.setLastUpdate(test.getLastUpdate());
        repo.save(testOriginal);
        ResPostTestDto testNuevo= mapper.map(testOriginal,ResPostTestDto.class);
        testNuevo.setMensaje("Actualizacion exitosa!");
        return testNuevo;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<ResPostTestDto> obtenerPorFecha(LocalDate last_update) {
        return repo.findAllByLastUpdateAfter(last_update).stream().map(m -> mapper.map(m,ResPostTestDto.class)).collect(Collectors.toList());
        /*return repo.findAll()
                .stream()
                .filter(t -> t.getLastUpdate().isAfter(last_update))
                .map(m -> mapper.map(m,ResPostTestDto.class))
                .collect(Collectors.toList());*/


    }

}
