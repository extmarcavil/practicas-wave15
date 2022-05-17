package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpTestCaseService implements ITestCaseService{
    private final ITestCaseRespository repo;
    ModelMapper mapper = new ModelMapper();

    public ImpTestCaseService(ITestCaseRespository repo) {
        this.repo = repo;
    }

    @Override
    public ResPostTestDto guardar(ReqTestCaseDto test){
        TestCase t = mapper.map(test, TestCase.class);

        ResPostTestDto responce = mapper.map(repo.save(t), ResPostTestDto.class);
        responce.setMensaje("todo ok");

        return responce;
    }
    @Override
    public List<TestCase> obtenerTodos(){
        return repo.findAll();
    }
    @Override
    public TestCase obtenerPorId(Long id){
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

}
