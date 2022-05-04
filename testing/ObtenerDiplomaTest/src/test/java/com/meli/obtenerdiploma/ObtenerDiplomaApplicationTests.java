package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;

//TODO: Casos nulos, vacíos, inválidos.
//TODO: Agregar un alumno.
//TODO: Buscar un alumno por Id.
//TODO: Modificar los datos de un alumno.
//TODO: Listar todos los alumnos.
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObetenerDiplomaApplicationTests {

	StudentRepository repository;
	IStudentDAO studentDAO;

	@Mock
	private IStudentDAO MockstudentDAO;

	@InjectMocks
	private ObtenerDiplomaService service;

	@BeforeEach
	void setup(){
		repository = new StudentRepository();
		studentDAO = new StudentDAO();
	}

	@Test
	public void analyzeScoresAverage9()
	{
		StudentDTO studentDTO = createStudent();
		Long studentId = 3L;
		when(MockstudentDAO.findById(studentId)).thenReturn(studentDTO);
		StudentDTO student = service.analyzeScores(studentId);
		Assertions.assertEquals(9.0,student.getAverageScore());
		Assertions.assertEquals("El alumno Belen ha obtenido un promedio de 9. Puedes mejorar.",student.getMessage());

	}

	@Test
	public void analyzeScoresAverage950()
	{
		StudentDTO studentDTO = createStudent950();
		Long studentId = 3L;
		when(MockstudentDAO.findById(studentId)).thenReturn(studentDTO);
		StudentDTO student = service.analyzeScores(studentId);
		Assertions.assertEquals(9.5,student.getAverageScore());
		Assertions.assertEquals("El alumno Belen ha obtenido un promedio de 9.5. Felicitaciones!",student.getMessage());

	}

	@Test
	public void analyzeScoresStudentIdNotFound()
	{
		when(MockstudentDAO.findById(4L)).thenThrow(StudentNotFoundException.class);
		Assertions.assertThrows(StudentNotFoundException.class,()->service.analyzeScores(4L));
	}

	@Test
	public void analyzeScoresStudentNull()
	{
		when(MockstudentDAO.findById(null)).thenThrow(StudentNotFoundException.class);
		Assertions.assertThrows(StudentNotFoundException.class,()->service.analyzeScores(null));
	}

	@Test
	public void deleteAlumnoOk()
	{
		boolean deleteResult = studentDAO.delete(1L);

		Assertions.assertTrue(deleteResult);
		Assertions.assertThrows(StudentNotFoundException.class,()->studentDAO.findById(1L));
	}

	@Test
	public void deleteAlumnoNotExist(){

		boolean deleteResult = studentDAO.delete(15L);

		Assertions.assertFalse(deleteResult);
		Assertions.assertThrows(StudentNotFoundException.class,()->studentDAO.findById(15L));

	}

	@Test
	public void findByIdExist(){
		StudentDTO studentExist = createStudentId1();
		StudentDTO student = studentDAO.findById(1L);

		Assertions.assertEquals(student,studentExist);
	}

	private StudentDTO createStudent()
	{
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName("Belen");
		studentDTO.setId(3L);
		SubjectDTO s1 = new SubjectDTO();
		s1.setName("Matematica");
		s1.setScore(9.0);
		SubjectDTO s2 = new SubjectDTO();
		s2.setName("Lengua");
		s2.setScore(9.0);
		List<SubjectDTO> subjectDTOS = new ArrayList<>();
		subjectDTOS.add(s1);
		subjectDTOS.add(s2);
		studentDTO.setSubjects(subjectDTOS);

		return studentDTO;
	}

	private StudentDTO createStudent950()
	{
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName("Belen");
		studentDTO.setId(3L);
		SubjectDTO s1 = new SubjectDTO();
		s1.setName("Matematica");
		s1.setScore(9.0);
		SubjectDTO s2 = new SubjectDTO();
		s2.setName("Lengua");
		s2.setScore(10.0);
		List<SubjectDTO> subjectDTOS = Arrays.asList(s1,s2);
		studentDTO.setSubjects(subjectDTOS);

		return studentDTO;
	}

	private StudentDTO createStudentId1(){
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName("Juan");
		studentDTO.setId(1L);
		SubjectDTO s1 = new SubjectDTO();
		s1.setName("Matemática");
		s1.setScore(9.0);
		SubjectDTO s2 = new SubjectDTO();
		s2.setName("Física");
		s2.setScore(7.0);
		SubjectDTO s3 = new SubjectDTO();
		s3.setName("Química");
		s3.setScore(6.0);
		List<SubjectDTO> subjectDTOS = Arrays.asList(s1,s2,s3);
		studentDTO.setSubjects(subjectDTOS);
		return studentDTO;
	}
}