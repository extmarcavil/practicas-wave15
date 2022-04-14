package ejercicio1;

public class Persona {

    private  String nombre;
    private  int edad;
    private  String dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC(){
        double imc = peso/(Math.pow(altura,2));
        if(imc<20){
            return -1;
        }else if(imc >= 20 && imc <= 25){
            return 0;
        }else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if(edad>=18){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", Nivel de peso= " +imprimirIMC()+
                " y "+
                 imprimirMayoriaEdad()
                +'}'
                ;
    }

    public String imprimirIMC(){
        if(calcularIMC()==-1){
            return "Bajo peso";
        }else if(calcularIMC()==0){
            return "Peso saludable";
        }else {
            return "Sobrepeso";
        }
    }

    public String imprimirMayoriaEdad(){
        if(esMayorDeEdad()==true){
            return "es mayor de edad";
        }else {
            return "es menor de edad";
        }
    }
}
