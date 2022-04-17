
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    //Constructores
    //Atajo: Command + N
    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC(){
        double imc = peso / (altura * altura);
        if (imc > 20) {
            return -1;
        }else if (imc>=20 && imc<=25) {
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return edad>=18;
    }

    public String toString(){
        return "Nombre: " + this.nombre + ", edad: " + this.edad + ", DNI: " + this.dni + ", peso: " + this.peso + " y altura: " + this.altura;
    }
}

