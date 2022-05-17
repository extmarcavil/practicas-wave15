package com.example.qatesters.api.mapper;

import com.example.qatesters.api.dto.IdCaseDto;
import com.example.qatesters.api.dto.TestCaseDto;
import com.example.qatesters.model.TestCase;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TestCaseMapper {
    TestCase testCaseDtoToTestCase(TestCaseDto testCaseDto);

    TestCaseDto testCaseToTestCaseDto(TestCase testCase);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTestCaseFromTestCaseDto(TestCaseDto testCaseDto, @MappingTarget TestCase testCase);

    TestCase idCaseToTestCase(IdCaseDto idCaseDto);

    IdCaseDto testCaseToIdCase(TestCase testCase);
}
