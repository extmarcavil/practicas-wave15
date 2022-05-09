package com.meli.obtenerdiploma.data;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.Arrays;
import java.util.List;

public class Data {

    public static final List<SubjectDTO> SUBJECT_DTOS_LIST =
            Arrays.asList(new SubjectDTO("Calculo", 10.0), new SubjectDTO("Fisica", 10.0));
    public static final StudentDTO STUDENT_DTO_1 = new StudentDTO("Pepe", null, null, SUBJECT_DTOS_LIST);


    public static final List<SubjectDTO> SUBJECT_DTOS_LIST1 =
            Arrays.asList(new SubjectDTO("Calculo", 8.0), new SubjectDTO("Fisica", 6.0));
    public static final StudentDTO STUDENT_DTO_2 = new StudentDTO("Jorge", null, null, SUBJECT_DTOS_LIST1);


    public static final List<SubjectDTO> SUBJECT_DTOS_LIST2 =
            Arrays.asList(new SubjectDTO("Calculo", 5.0), new SubjectDTO("Fisica", 10.0));
    public static final StudentDTO STUDENT_DTO_3 = new StudentDTO("Javier", null, null, SUBJECT_DTOS_LIST2);

    public static final List<SubjectDTO> SUBJECT_DTOS_LIST3 =
            Arrays.asList(new SubjectDTO("Calculo", 2.0), new SubjectDTO("Fisica", 7.0));
    public static final StudentDTO STUDENT_DTO_4 = new StudentDTO("Ricardo", null, null, SUBJECT_DTOS_LIST3);


}
