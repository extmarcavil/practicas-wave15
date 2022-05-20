package ar.com.alehenestroza.nosqlempleados.repository;

import ar.com.alehenestroza.nosqlempleados.entities.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
}
