package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpTestCaseService implements ITestCaseService{
    private ITestCaseRespository repo;
    private ModelMapper modelMapper;

    public ImpTestCaseService(ITestCaseRespository repo) {
        this.repo = repo;
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
    }

    @Override
    public ResPostTestDto guardar(ReqTestCaseDto test){
        TestCase t = new TestCase(test.getDescription(),
                test.getTested(),
                test.getPassed(),
                test.getNumber_of_tries(),
                test.getLastUpdate());

        repo.save(t);

        ResPostTestDto respuesta = new ResPostTestDto(t.getDescription(),
                t.getTested(),t.getPassed(),t.getNumber_of_tries(),t.getLastUpdate(),"todo ok");

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
    public void delete(Long id) {
        repo.deleteById(id);
    }

    //Tener en cuenta que las clases tiene nombres diferentes para el atriburo descripcion.
    @Override
    public void actualizar(Long id, ReqTestCaseDto test) {
        TestCase testCase = repo.findById(id).orElseThrow(()->new RuntimeException());
        modelMapper.map(test,testCase);
        repo.save(testCase);
    }

}
