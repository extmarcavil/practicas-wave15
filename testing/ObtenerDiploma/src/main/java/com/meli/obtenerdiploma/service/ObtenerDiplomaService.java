package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.ExceptionCustom;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Override
    public StudentDTO analyzeScores(StudentDTO rq) {
        if(!Character.isUpperCase(rq.getStudentName().charAt(0)))
            throw new ExceptionCustom("El nombre del alumno debe comenzar con mayúscula.");

        for (SubjectDTO subject: rq.getSubjects()){
            if(!Character.isUpperCase(subject.getName().charAt(0)))
                throw new ExceptionCustom("El nombre de la materia debe comenzar con mayúscula.");
        }

        rq.setAverageScore(calculateAverage(rq.getSubjects()));
        rq.setMessage(getGreetingMessage(rq.getStudentName(), rq.getAverageScore()));

        return rq;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }


}
