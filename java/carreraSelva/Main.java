package carreraSelva;

import carreraEnLaSelva.Categoria;
import carreraEnLaSelva.Participante;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


  //  Carrera de la Selva
  //Todos los años en la provincia de Misiones, al norte de Argentina se lleva a cabo un evento conocido como “Carrera de la Selva”.
    // El mismo se trata de una competición donde los mejores maratonistas y corredores de Latinoamérica se reúnen para desafiar sus habilidades deportivas.
  // La competencia cuenta con 3 categorías dependiendo de su dificultad:
  // Circuito chico: 2 km por selva y arroyos.
  // Circuito medio: 5 km por selva, arroyos y barro.
  // Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
  //  Cada participante puede inscribirse únicamente a una categoría y necesita, para dicha inscripción, proporcionar los siguientes datos: dni,
    //  nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo. A cada inscripto, a la vez, se le asigna un número de participante consecutivo
    //  con respecto a la inscripción anterior; por ejemplo, si un participante se inscribe y el anterior fue el número 36, se le va a asignar el número 37.
    //  /  Para concluir con la inscripción, se debe calcular el monto a abonar por cada participante. Para ello se tienen en cuenta los siguientes valores:
  //  Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
  //  Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
    //  Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800

    // A partir de estos datos brindados, los organizadores de la carrera manifestaron que necesitan de una aplicación que sea capaz de:

    //  Inscribir a un nuevo participante en una categoría. (Tener en cuenta que cada categoría tiene una lista de inscriptos diferente).
    //  Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
    //  Desinscribir a un participante de una categoría.
    //  Determinar el monto que deberá abonar cada participante al inscribirse. Por ejemplo: si el participante se inscribe a la categoría Circuito chico
    //  y tiene 21 años, el monto a abonar es de $1500.


    public static void main(String[] args) {
        List<Participante> participantes = new ArrayList<Participante>();
        List<carreraEnLaSelva.Categoria> circuitoChico = new ArrayList<carreraEnLaSelva.Categoria>();
        List<carreraEnLaSelva.Categoria> circuitoMedio = new ArrayList<carreraEnLaSelva.Categoria>();
        List<carreraEnLaSelva.Categoria> circuitoAvanzado = new ArrayList<carreraEnLaSelva.Categoria>();
        JOptionPane.showMessageDialog(null, "Inscribir un participante");
        Participante participante = addParticipante();
        participantes.add(participante);

        int reply = JOptionPane.showConfirmDialog(null, "Te gustaria agregar otro participante", "-", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
                Participante participante2 = addParticipante();
                participantes.add(participante2);
        } else {
          return;
            }


        int monto = 0;
        for (Participante parti : participantes) {


            switch (parti.getCategoria()) {
                case "Circuito Chico":
                    if (parti.getEdad() > 18) {
                        monto = 1500;
                    } else {
                        monto = 1300;
                    }
                    carreraEnLaSelva.Categoria categoria1 = new carreraEnLaSelva.Categoria(parti, monto, 1);
                    circuitoChico.add(categoria1);
                case "Circuito Medio":
                    if (parti.getEdad() > 18) {
                        monto = 2300;
                    } else {
                        monto = 2000;
                    }
                    carreraEnLaSelva.Categoria categoria2 = new carreraEnLaSelva.Categoria(parti, monto, 1);
                    circuitoMedio.add(categoria2);
                case "Circuito Avanzado":
                    if (parti.getEdad() > 18) {
                        monto = 2800;
                    } else {
                        monto = 0;
                    }
                    carreraEnLaSelva.Categoria categoria3 = new carreraEnLaSelva.Categoria(parti, monto, 1);
                    circuitoAvanzado.add(categoria3);
                default:
                    monto = 0;
            }

        }
        showAll(circuitoChico);
        showAll(circuitoAvanzado);
        showAll(circuitoMedio);
        System.exit(0);


    }
    public static void showAll(List<carreraEnLaSelva.Categoria> cat){
        for (Categoria cate: cat){
            JOptionPane.showMessageDialog(null, "<html>Participantes Categoria" + cate.getParticipante().getCategoria() + ": <br> Nombre: "
                    + cate.getParticipante().getNombre() + "<br> Apellido: "
                    +  cate.getParticipante().getApellido() + "<br> Celular: "
                    +  cate.getParticipante().getCelular() + "<br> Grupo Sanguineo: "
                    +  cate.getParticipante().getGrupoSanguineo() + "<br> Dni:"
                    +  cate.getParticipante().getDni() + "<br> Edad: "
                    +  cate.getParticipante().getEdad() + "<br> Tel de Emergencia: "
                    +  cate.getParticipante().getTelEmergencia() + "<br> Nro Participante: "
                    + cate.getNroParticipante() + "<br> Monto: " +
                    + cate.getMonto());

        }
    }

    public static Participante addParticipante(){


        String nombre = JOptionPane.showInputDialog("Ingrese el nombre");

        String apellido = JOptionPane.showInputDialog("Ingrese el apellido");
        int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dni"));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad"));
        int celular = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el celular"));
        int telEmergencia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tel de emergencia"));
        String grupoSanguineo = JOptionPane.showInputDialog("Ingrese el grupo sanguineo");
        int monto = 0;

        String[] categorias = {"Circuito Chico", "Circuito Medio", "Circuito Avanzado"};

        String categoria = (String) JOptionPane.showInputDialog(
                null,
                "¿En que categoria se desea inscribir?",
                "Carreras",
                JOptionPane.QUESTION_MESSAGE,
                null,
                categorias,
                categorias[2]);

        Participante participante = new Participante(nombre, apellido, dni, edad, celular, telEmergencia, grupoSanguineo, categoria);
        return participante;


    }
}
