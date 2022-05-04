package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class StudentDAO implements IStudentDAO {

    private Set<StudentDTO> students;

    public StudentDAO() {
        this.loadData();
    }

    @Override
    public void save(StudentDTO stu) {
        boolean removed = this.delete(stu.getId());

        if (!removed) stu.setId((this.students.size() + 1L));

        students.add(stu);
    }

    @Override
    public boolean delete(Long id) {
        boolean ret = false;

        try {
            StudentDTO found = this.findById(id);

            students.remove(found);
            ret  = true;

        } catch (StudentNotFoundException ignored) {}

        return ret;
    }

    public boolean exists(StudentDTO stu) {
       boolean ret = false;

       try {
           ret  = this.findById(stu.getId()) != null;
       }
       catch (StudentNotFoundException ignored) {}

       return ret;
    }

    @Override
    public StudentDTO findById(Long id) {
        return students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst().orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public Set<StudentDTO> findAll() {
        return students;
    }

    private void loadData() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<>() {});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.students = loadedData;
    }
}
