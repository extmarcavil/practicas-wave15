package com.meli.studenttest.repository;

import com.meli.studenttest.dto.SubjectDto;
import com.meli.studenttest.dto.response.ResponseStudentDto;
import com.meli.studenttest.exception.StudentAlreadyExistsException;
import com.meli.studenttest.exception.StudentNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;

@Repository
public class ResponseStudentRepository extends AbstractCrudRepository<Long, ResponseStudentDto> {

    @Override
    protected List<ResponseStudentDto> loadData() {
        return Stream.of(
                new ResponseStudentDto(1L, "Pepe", "Nothing", 5D, emptyList()),
                new ResponseStudentDto(2L, "Ricardo", "Nothing", 10D, List.of(
                        new SubjectDto("Literature", 10))
                )
        ).collect(Collectors.toList());
    }

    @Override
    public void findByIdForUpdate(Long id, Consumer<ResponseStudentDto> callback) {
        ResponseStudentDto studentDto = findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        callback.accept(studentDto);
    }

    @Override
    public void save(ResponseStudentDto entity) {
        if (exists(entity)) {
            throw new StudentAlreadyExistsException(entity);
        }
        repository.add(entity);
    }

    @Override
    public boolean delete(Long id) {
        return findById(id)
                .map(maybeStudent -> repository.remove(maybeStudent))
                .orElse(false); // esto es feo :P
    }

    @Override
    public boolean exists(ResponseStudentDto entity) {
        return repository.contains(entity);
    }

    @Override
    public Optional<ResponseStudentDto> findById(Long id) {
        return repository.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<ResponseStudentDto> findAll() {
        return repository;
    }

    @Override
    public void update(ResponseStudentDto responseStudentDto) {
        int index = repository.indexOf(responseStudentDto);
        repository.set(index, responseStudentDto);
    }

}
