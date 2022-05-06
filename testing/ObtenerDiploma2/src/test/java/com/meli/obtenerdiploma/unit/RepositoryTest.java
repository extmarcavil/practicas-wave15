package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.*;

public class RepositoryTest {

    IStudentRepository studentRepository;
    IStudentDAO studentDAO;
    // Se requiere crear los tests unitarios necesarios
    // para cubrir el comportamiento de la capa de
    // repositorio StudentDAO y StudentRepository. Tener
    // en cuenta múltiples escenarios y “casos borde”
    // de cada comportamiento.
    //Casos nulos, vacíos, inválidos.
    //Agregar un alumno.
    //Buscar un alumno por Id.
    //Modificar los datos de un alumno.
    //Eliminar un alumno.
    //Listar todos los alumnos.

    @BeforeEach
    void setUp() {
        this.studentRepository = new StudentRepository();
        this.studentDAO = new StudentDAO();
    }

    //@AfterEach
    //void tearDown(){
        //studentDAO.delete()
    //}


    @Test
    @DisplayName("Test que chequea que se haya agregado un alumno correctamente")
    public void test01AgregarUnAlumno(){
        //Arrange
        int cantidadDeAlumnosInicial = studentDAO.getAmountOfStudents();

        //Act
        studentDAO.save(new StudentDTO());

        //Assert
        int cantidadDeAlumnosPosteriorAlAgregado = studentDAO.getAmountOfStudents();

        Assertions.assertEquals( cantidadDeAlumnosPosteriorAlAgregado,cantidadDeAlumnosInicial + 1);
    }

    @Test
    @DisplayName("Test que encuentra un alumno creado previamente")
    public void test02EncontrarUnAlumnoPorID(){
        //Arrange
        StudentDTO aStudent = new StudentDTO();
        studentDAO.save(aStudent);
        long idToSearch = aStudent.getId();

        //Act
        StudentDTO findedStudent = studentDAO.findById(idToSearch);

        //Assert
        Assertions.assertEquals(aStudent,findedStudent);
    }

    @Test
    @DisplayName("Test que chequea que se haya eliminado un alumno correctamente")
    public void test03EliminarUnAlumno(){
        //Arrange
        StudentDTO aStudentToDelete = new StudentDTO();
        studentDAO.save(aStudentToDelete);
        long idToDelete =  aStudentToDelete.getId();
        int cantidadDeAlumnosInicial = studentDAO.getAmountOfStudents();

        //Act
        studentDAO.delete(idToDelete);

        //Assert
        int cantidadDeAlumnosPosteriorAlBorrado = studentDAO.getAmountOfStudents();

        Assertions.assertEquals( cantidadDeAlumnosPosteriorAlBorrado,cantidadDeAlumnosInicial  - 1);
    }

    @Test
    @DisplayName("Test que chequea que si no existe el alumno devuelve excepcion")
    public void test04SiNoEncuentroAlumnoLanzoExcepcion(){
        //Arrange
        int cantidaDeAlumnos = studentDAO.getAmountOfStudents();
        long invalidId = 100 + cantidaDeAlumnos;
        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class,()->studentDAO.findById(invalidId));
    }

}
