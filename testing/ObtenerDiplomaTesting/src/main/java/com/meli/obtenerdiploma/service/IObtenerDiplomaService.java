package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(Long studentId);
}
