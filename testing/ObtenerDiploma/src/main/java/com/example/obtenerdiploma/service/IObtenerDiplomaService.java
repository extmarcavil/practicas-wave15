package com.example.obtenerdiploma.service;

import com.example.obtenerdiploma.model.StudentDTO;

public interface IObtenerDiplomaService {
    StudentDTO analyzeScores(StudentDTO rq);
}
