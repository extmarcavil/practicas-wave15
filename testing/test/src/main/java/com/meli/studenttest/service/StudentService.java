package com.meli.studenttest.service;

import com.meli.studenttest.dto.SubjectDto;
import com.meli.studenttest.dto.request.RequestStudentDto;
import com.meli.studenttest.dto.response.ResponseStudentDto;
import com.meli.studenttest.repository.ResponseStudentRepository;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final ResponseStudentRepository repository;

    @Autowired
    public StudentService(ResponseStudentRepository repository) {
        this.repository = repository;
    }

    public ResponseStudentDto calculateAverage(RequestStudentDto studentDto) {
        Tuple2<Double, List<SubjectDto>> dataCourses = calculateAverageScoreFrom(studentDto.getSubjects());
        return ResponseStudentDto.from(studentDto.getName(), dataCourses);
    }

    private Tuple2<Double, List<SubjectDto>> calculateAverageScoreFrom(List<SubjectDto> subjects) {
        return Tuple.of(subjects.stream()
                .mapToDouble(SubjectDto::getScore)
                .average()
                .orElse(0), subjects);
    }

    public void update(ResponseStudentDto studentDto) {
        repository.findByIdForUpdate(studentDto.getId(), student -> {
            // update student and save...
            repository.update(studentDto);
        });
    }
}
