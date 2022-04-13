package ejercicios;

public class Persona {

    private String nombre;
    private float altura;
    private String dni;
    private float peso;
    private int edad;

    public Persona() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int cacularIMC(){
        float IMC;
        IMC = this.peso/(this.altura  * this.altura);
        if(IMC < 20){
            return -1;
        }else{
            if(IMC>= 20 && IMC <= 25){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public boolean esMayorEdad(){
        return (this.edad >= 18);
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
