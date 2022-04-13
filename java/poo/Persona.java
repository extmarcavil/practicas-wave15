package poo;

public class Persona {
    String nombre;
    int edad;
    String dni;
    Float peso;
    Float altura;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.peso = 0f;
        this.altura = 0f;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, Float peso, Float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }
    public int calcularIMC(){
     int imcStatus =0;
     float imc;
     float alturaMetros = altura / 100;
     imc = peso/(alturaMetros*alturaMetros);
        if(imc < 20f ) imcStatus = -1;
        if(imc >= 20f && imc <=25f) imcStatus=0;
        if (imc > 25f) imcStatus = 1;
        System.out.println(imcStatus + " " + imc);
        return imcStatus;
    }
    public boolean esMayorDeEdad(){
        if(edad>=18)return true;
        else return false;
    }
    public String toString(){
        return (" Nombre: "+ nombre +"\n Edad: "+ edad + "\n Dni: " + dni + "\n Peso: " + peso + "Kg \n Altura:" + altura);
    }
    public String toStringComplete(){
        String imcDescriptivo ="";
        String mayorEdadDescriptivo;
        switch (calcularIMC()){
            case -1 : imcDescriptivo = "Bajo peso"; break;
            case 0 : imcDescriptivo = "Peso Saludable";break;
            case 1 : imcDescriptivo = "Sobrepeso";break;
        }
        if(esMayorDeEdad()) mayorEdadDescriptivo = "Es mayor de edad";
        else mayorEdadDescriptivo = "No es mayor de edad";

        return (" Nombre: "+ nombre +"\n Edad: "+ edad + "\n Dni: " + dni +
                "\n Peso: " + peso + "Kg \n Altura:" + altura + " " +
                "\n IMC: " + imcDescriptivo + " \n " + mayorEdadDescriptivo );
    }

}
