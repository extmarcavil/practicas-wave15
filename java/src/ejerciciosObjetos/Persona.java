package ejerciciosObjetos;

public class Persona {

    String nombre;
    int edad;
    String dni;
    int peso;
    int altura;


    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }


    public Persona() {
    }

    public Persona(String nombre, int edad, String dni, int peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int cacularIMC(){
        int valor = peso/((altura/100)^2);
        int valorRet;
        if(valor < 20) {
            valorRet = -1;
        }else{
            if(valor >= 20 && valor <= 25){
                valorRet = 0;
            }else{
                valorRet = 1;
            }
        }
        return  valorRet;
    }
     public boolean esMayorDeEdad(){
        return edad >= 18;
     }

    @Override
    public String toString() {
        return "Nombre: '" + nombre + '\'' +
                " Edad: " + edad +
                " DNI: '" + dni + '\'' +
                " Peso: " + peso +
                " Altura: " + altura;
    }
}
