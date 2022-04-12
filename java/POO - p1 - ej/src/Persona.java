public class Persona {
    String nombre, dni;
    double peso, altura;
    int edad;

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(){}

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", edad=" + edad +
                '}';
    }

    public int calcularIMC(){
        double imc = this.peso/(this.altura*this.altura);
        if (imc<20){
            return -1;
        } else {
            if(imc>25){
                return 1;
            }else{
                return 0;
            }
        }
    }

    public boolean esMayorDeEdad(){
        if (this.edad>=18){
            return true;
        }
        return false;
    }
}
