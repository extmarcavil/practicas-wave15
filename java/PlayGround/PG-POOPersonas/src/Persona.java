

public class Persona {

    private String nombre;
    private float altura;
    private String dni;
    private float peso;
    private int edad;

    public Persona() {
        this.nombre = "";
        this.dni = "";
        this.edad = 0;
    }

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, float altura, String dni, float peso, int edad) {
        this.nombre = nombre;
        this.altura = altura;
        this.dni = dni;
        this.peso = peso;
        this.edad = edad;
    }

    public int cacularIMC(){
        float IMC;
        IMC = this.peso/(this.altura * this.altura);
        if(IMC < 20){
            return -1;
        }else{
            if(IMC <= 25){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public boolean esMayorEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return
                "Nombre = " + nombre + '\n' +
                "Altura = " + altura + '\n' +
                "DNI = " + dni +  '\n' +
                "Peso = " + peso + '\n' +
                "Edad = " + edad;
    }
}
