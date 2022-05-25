package com.elasticS.elasticS;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    @Override
    List<Employee> findAll();
    Optional<Employee> findEmployeeByAge(Integer age);
    List<Employee> findAllByAge(Integer age);
    List<Employee> findAllByNameLike(String name);
/*
Si quiero que en la respuesta me devuelva solo los elementos que cree, sobreescribo el findAll
La respuesta es:

[
    {
        "id": "employees",
            "name": "lklkAna",
            "lastname": "salomllikone",
            "age": 21,
            "city": "mlñldz",
            "date": null
    }
]
*/


/*Si no la sobreescribo, la respuesta sera:

    {
        "content": [
        {
            "id": "employees",
                "name": "lklkAna",
                "lastname": "salomllikone",
                "age": 21,
                "city": "mlñldz",
                "date": null
        }
    ],
        "pageable": {
        "sort": {
            "unsorted": true,
                    "sorted": false,
                    "empty": true
        },
        "pageNumber": 0,
                "pageSize": 5,
                "offset": 0,
                "paged": true,
                "unpaged": false
    },
        "totalPages": 1,
            "totalElements": 5,
            "last": true,
            "number": 0,
            "sort": {
        "unsorted": true,
                "sorted": false,
                "empty": true
    },
        "numberOfElements": 5,
            "first": true,
            "size": 5,
            "empty": false
    }*/
}
