package com.meli.elasticsearch.service;

import com.meli.elasticsearch.domain.Employee;
import com.meli.elasticsearch.dto.EmployeeDto;
import com.meli.elasticsearch.repository.EmployeeRepository;
import com.meli.elasticsearch.repository.GenericElasticsearchRepository;
import com.meli.elasticsearch.utils.JsonAdapter;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService extends ClientElasticService<EmployeeDto, Employee> {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           RestHighLevelClient client,
                           ElasticsearchOperations elasticsearchOperations,
                           JsonAdapter adapter) {
        super(elasticsearchOperations, client, adapter);
        this.employeeRepository = employeeRepository;
    }

    @Override
    protected Map<String, Object> createParametersFrom(EmployeeDto dto) {
        Map<String, Object> parameters = new HashMap<>() {
            {
                put("name", dto.getName());
                put("age", dto.getAge());
                put("state", dto.getState());
                put("postal_code", dto.getPostalCode());
            }
        };

        return filterNullValues(parameters);
    }

    @Override
    protected Employee elementForSaveFrom(EmployeeDto employeeDto) {
        return Employee.forSave(employeeDto);
    }

    @Override
    protected Employee elementForUpdateFrom(EmployeeDto employeeDto) {
        return repository().findByIdForUpdate(
                employeeDto.getId(),
                employee -> employee.updateFrom(employeeDto)
        );
    }

    @Override
    protected String index() {
        return Employee.INDEX;
    }

    @Override
    protected GenericElasticsearchRepository<Employee> repository() {
        return employeeRepository;
    }

    @Override
    protected Class<Employee> entity() {
        return Employee.class;
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    public Employee findById(String id) {
        return repository().getEntity(id);
    }

    /*private QueryBuilder createQueryWithField(String field, Object value) {
        return matchQuery(field, value);
    }*/

    public List<EmployeeDto> findAllAsDto() {
        return null;
    }

}
