public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    //constructor vacio
    public Persona(){

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }



    public double calcularMC(double peso, double altura){
        double resultado = peso / (altura * altura);
        double retorno = 0;
        if (resultado < 20){
            retorno = -1;
        }
        if (resultado >= 20 && resultado <= 25){
            retorno = 0;
        }
        if (resultado > 25){
            retorno = 1;
        }
        return retorno;
    }


    public boolean esMayorDeEdad(int edad){
        boolean mayor = false;
        if (edad > 18) {
            mayor = true;
        }
        return mayor;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura;
    }
}