public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){}

    public Persona(String nombre, int edad,String dni){
        this.edad = edad;
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC()
    {
        double imc = this.peso / Math.pow(this.altura,2);

        if(imc <20 )
        {
            return -1;
        }else if (imc <=25){
            return 0;
        }else{
            return 1;
        }

    }

    public boolean esMayorDeEdad()
    {
        return this.edad >17;
    }

    public String toString()
    {
        return "El nombre de la persona es " + this.nombre + ", su edad es "+ this.edad + ", pesa "  + this.peso + " , mide mts "+ this.altura + " y su dni es " + this.dni;
    }

}
