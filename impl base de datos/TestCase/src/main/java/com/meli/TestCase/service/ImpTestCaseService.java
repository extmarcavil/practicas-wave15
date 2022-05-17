package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.repository.ITestCaseRespository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<TestCase> obtenerTodos(String lastUpdate){
        List<TestCase> respuesta = repo.findAll();
        LocalDate date;
        if(!lastUpdate.isBlank()){
            try {
                 date = LocalDate.parse(lastUpdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e){
                return null;
            }
            return respuesta
                    .stream()
                    .filter(t -> t.getLastUpdate().isAfter(date))
                    .collect(Collectors.toList());
        }
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
