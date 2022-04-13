import java.util.HashMap;
import java.util.Map;

public class Carrera {

    Map<Integer, String> circuitoChico = new HashMap<>();
    Map<Integer, String> circuitoMedio = new HashMap<>();
    Map<Integer, String> circuitoAvanzado = new HashMap<>();
    Integer numeroCorredor = 1;
    private Integer inscipcion;

    public Carrera(String datosPersonales, Integer edad, String tipoCircuito){

        if(tipoCircuito.contains("chico")){

            if(edad<18){
                inscipcion = 1300;
                String datosInscipcion = datosPersonales + ", Valor Inscipción $" + inscipcion;
                circuitoChico.put(numeroCorredor, datosInscipcion);
            }
            else{
                inscipcion = 1500;
                String datosInscipcion = datosPersonales + ", Valor Inscipción $" + inscipcion;
                circuitoChico.put(numeroCorredor, datosInscipcion);
            }
        }

        if(tipoCircuito.contains("medio")){

            if(edad<18){
                inscipcion = 2000;
                String datosInscipcion = datosPersonales + ", Valor Inscipción $" + inscipcion;
                circuitoMedio.put(numeroCorredor, datosInscipcion);
            }
            else{
                inscipcion = 2300;
                String datosInscipcion = datosPersonales + ", Valor Inscipción $" + inscipcion;
                circuitoMedio.put(numeroCorredor, datosInscipcion);
            }
        }

        if(tipoCircuito.contains("avanzado")) {

            if (edad < 18) {
                String datosInscipcion = "No puede antotarse, ya que el circuito avanzado solo permite personas mayores de edad";
                System.out.println(datosInscipcion);

            } else {
                inscipcion = 2800;
                String datosInscipcion = datosPersonales + ", Valor Inscipción $" + inscipcion;
                circuitoAvanzado.put(numeroCorredor, datosInscipcion);
            }
        }
    }

    public String imprimirCorto() {
        String toString = "";
        for(Map.Entry<Integer, String> entrada : circuitoChico.entrySet()){
            Integer clave = entrada.getKey();
            String valor = entrada.getValue();
            toString = "Circuito Chico. Número corredor: "+ clave + ", " + valor;
        }
        return toString;
    }

    public String imprimirMedio() {
        String toString = "";
        for(Map.Entry<Integer, String> entrada : circuitoMedio.entrySet()){
            Integer clave = entrada.getKey();
            String valor = entrada.getValue();
            toString = "Circuito Medio. Número corredor: "+ clave + ", " + valor;
        }
        return toString;
    }

    public String imprimirAvanzado() {
        String toString = "";
        for(Map.Entry<Integer, String> entrada : circuitoAvanzado.entrySet()){
            Integer clave = entrada.getKey();
            String valor = entrada.getValue();
            toString = "Circuito Avanzado. Número corredor: "+ clave + ", " + valor;
        }
        return toString;
    }
}
