package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.aspectj.weaver.ast.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ImpTestCaseService implements ITestCaseService{
    private final ModelMapper modelMapper;

    private ITestCaseRespository repo;

    public ImpTestCaseService(ITestCaseRespository repo) {
        this.modelMapper = new ModelMapper();
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

        ResPostTestDto respuesta = new ResPostTestDto(t.getDesc(),
                t.isTested(),t.isPassed(),t.getNumber_of_tries(),t.getLastUpdate(),"todo ok");

        return respuesta;
    }
    @Override
    public List<TestCase> obtenerTodos(String aPartirDeFecha){
        List<TestCase> respuesta;

        if(aPartirDeFecha == null)
            respuesta = repo.findAll();
        else
            respuesta = repo.findAllByDateAfter(LocalDate.parse(aPartirDeFecha, DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        return respuesta;
    }

    @Override
    public TestCase obtenerPorId(Long id){
        TestCase test = repo.findById(id).orElseThrow(RuntimeException::new);
        return test;
    }

    @Override
    public ResPostTestDto actualizarPorId(Long id, ReqTestCaseDto test){
        //TestCase t = repo.findById(id).orElseThrow(RuntimeException::new);
        TestCase t = modelMapper.map(test, TestCase.class);
        t.setId(id);
        repo.save(t);
        ResPostTestDto res = new ResPostTestDto();
        return res;
    }

    @Override
    public void eliminarPorId(Long id) {
        //TestCase t = repo.findById(id).orElseThrow(RuntimeException::new);
        repo.deleteById(id);
    }

}
