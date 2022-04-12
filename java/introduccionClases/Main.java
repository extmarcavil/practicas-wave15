package introduccionClases;

public class Main {
    //Desde la clase Main vamos a calcular el IMC de la última persona que creamos
    //(la que creamos correctamente mediante el constructor que recibe todos los atributos como parámetro).
    //También vamos a averiguar si es mayor de edad o no; ten en cuenta que en ambos casos, dependiendo de los
    //resultados retornados por los métodos, debes imprimir un mensaje acorde para el usuario. Finalmente queremos
    //mostrar todos los datos de esa persona imprimiendo dicha información por consola. El formato en que vas a
    //mostrar los datos y los mensajes quedan a tu criterio, pero debe ser legible y descriptivo para quien ve la
    //salida del programa.
    public static void main(String[] args) {
	Persona p = new Persona("ana", 12, "43567544", 58, 160);

	p.calcularIMC();
	p.esMayorDeEdad();
    }
}
