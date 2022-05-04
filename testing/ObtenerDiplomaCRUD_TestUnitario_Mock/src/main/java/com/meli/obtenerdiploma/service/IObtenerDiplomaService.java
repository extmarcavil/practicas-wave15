package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.dao.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(Long studentId);
}
