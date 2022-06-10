public class Persona {

    private String nombre;
    private int edad;
    private String DNI;
    private double peso;
    private double altura;


    public Persona() {
    }

    public Persona(String nombre, int edad, String DNI) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }

    public Persona(String nombre, int edad, String DNI, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(double peso,double altura){
        int valor;
        double imc = (peso/Math.pow(altura,2));
        if(imc<20){
            valor = 1;
        }else if(imc >=20 && imc<25){
            valor = 0;
        }else
            valor = -1;
        return valor;
    }

    public boolean esMayorDeEdad(int edad){
        boolean esMayor;
        if(edad >=18){
            esMayor= true;
        }else{
            esMayor=false;
        }
        return esMayor;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", DNI='" + DNI + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
