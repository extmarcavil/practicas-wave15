package CarrerasSelva;

import java.util.HashMap;
import  java.util.Map;

public class circuitos {

    public static HashMap<Integer,String> Getcategorias(){
        var categorias = new HashMap<Integer,String>();
        categorias.put(1,"Circuito chico");
        categorias.put(2,"Circuito medio");
        categorias.put(3,"Circuito Avanzado");

        return  categorias;
    }

    public static int GetIdNuevoParticipante(HashMap<Integer,String> DiccionarioParticipantes){
        int IdParticipante = 0;
        for (Map.Entry<Integer, String> entry : DiccionarioParticipantes.entrySet()) {
             IdParticipante = entry.getKey();
        }
        return IdParticipante = IdParticipante + 1;
    }

    public static HashMap<Integer,String> ParticipanteNombre(int IdParticipante,String Nombre,HashMap<Integer,String> Participantes){
        Participantes.put(IdParticipante,Nombre);
        return Participantes;
    }

    public static HashMap<Integer,Integer> ParticipanteEdad(int IdParticipante,int Edad,HashMap<Integer,Integer> Participantes){
        Participantes.put(IdParticipante,Edad);
        return Participantes;
    }


    public static HashMap<Integer,Integer>  InscribirCursoParticipante(int IdParticipante,int IdCurso,
                                                                       HashMap<Integer,Integer> Curso,HashMap<Integer,Integer> Edades){
        if (IdCurso == 3){
            var where = Edades.get(IdParticipante);
            if(where < 18)
                System.out.println("No se pueden inscribir participantes menores a 18 años al curso avanzado");
            else
                Curso.put(IdParticipante,IdCurso);
        }
        else{
            Curso.put(IdParticipante,IdCurso);
        }
        return Curso;
    }

    public static HashMap<Integer,Integer>  DesinscribirCursoParticipante(int IdParticipante,int IdCurso,HashMap<Integer,Integer> Curso){
        Curso.remove(IdParticipante);

        return Curso;
    }

    public static void main(String[] args) {
        var cat = Getcategorias();
        var participantes = new HashMap<Integer,String>();
        var CursoChico = new HashMap<Integer,Integer>();
        var CursoMedio = new HashMap<Integer,Integer>();
        var CursoAvanzado = new HashMap<Integer,Integer>();
        var EdadesParticipantes = new HashMap<Integer,Integer>();
        var idParticipanteNuevo = GetIdNuevoParticipante(participantes);
        participantes = ParticipanteNombre(idParticipanteNuevo,"Gerson Jair",participantes);
        EdadesParticipantes = ParticipanteEdad(idParticipanteNuevo,29,EdadesParticipantes);
        var idParticipanteNuevo2 = GetIdNuevoParticipante(participantes);
        EdadesParticipantes = ParticipanteEdad(idParticipanteNuevo2,39,EdadesParticipantes);
        participantes = ParticipanteNombre(idParticipanteNuevo2,"Messi",participantes);
        var idParticipanteNuevo3 = GetIdNuevoParticipante(participantes);
        participantes = ParticipanteNombre(idParticipanteNuevo3,"Ronaldo",participantes);
        EdadesParticipantes = ParticipanteEdad(idParticipanteNuevo3,17,EdadesParticipantes);
        CursoChico = InscribirCursoParticipante(idParticipanteNuevo,1,CursoChico,EdadesParticipantes);
        CursoMedio = InscribirCursoParticipante(idParticipanteNuevo2,2,CursoMedio,EdadesParticipantes);
        CursoAvanzado = InscribirCursoParticipante(idParticipanteNuevo3,3,CursoAvanzado,EdadesParticipantes);
        CursoAvanzado = InscribirCursoParticipante(idParticipanteNuevo,3,CursoAvanzado,EdadesParticipantes);

    }
}
