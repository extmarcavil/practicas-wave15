package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.exception.TestNotFoundException;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpTestCaseService implements ITestCaseService{
    private ITestCaseRespository repo;
    private final ModelMapper mapper;

    public ImpTestCaseService(ITestCaseRespository repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
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
    public List<TestCase> obtenerTodos(LocalDate date){

        List<TestCase> respuesta = repo.findAll();
        if(date!=null){
            respuesta = respuesta.stream().filter(r -> r.getLastUpdate().isAfter(date)).collect(Collectors.toList());
        }
        return respuesta;
    }
    @Override
    public TestCase obtenerPorId(Long id){
        TestCase test = repo.findById(id).orElseThrow(()->new TestNotFoundException("No existe el test con id: " + id));
        return test;
    }



    @Override
    public void eliminarPorId(Long id) {
        repo.findById(id).orElseThrow(()->new RuntimeException());
        repo.deleteById(id);
    }

    @Override
    public ResPostTestDto modificar(Long id, ReqTestCaseDto testMod) {
        TestCase test = repo.findById(id).orElseThrow(()->new TestNotFoundException("No existe el test con id: " + id));
        test.setDescription(testMod.getDesc());
        test.setTested(testMod.isTested());
        test.setPassed(testMod.isPassed());
        test.setLastUpdate(testMod.getLastUpdate());
        test.setNumber_of_tries(testMod.getNumber_of_tries());
        repo.save(test);
        Mapper map = new Mapper();
        ResPostTestDto resp = mapper.map(test,ResPostTestDto.class);
        resp.setDesc(test.getDescription());
        resp.setMensaje("Updated correctly");
        return resp;
    }
}
