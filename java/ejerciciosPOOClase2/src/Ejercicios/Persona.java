package Ejercicios;
import java.lang.Math;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String DNI){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = DNI;
    }

    public Persona(String nombre, int edad, String DNI, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = DNI;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double potenciarAltura = Math.pow(this.altura, 2);
        double IMC = 0;
        IMC = this.peso/potenciarAltura;
        if(IMC < 20){
            return -1;
        }else if(IMC >= 20 && IMC <= 25){
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        if(this.edad < 18){
            return false;
        }
        return true;
    }

    public String toString(){
       String informacion = ("La persona " + this.nombre + " tiene " + this.edad + " años. Su DNI es " + this.dni + ". Su peso es " + this.peso + " y su altura es " + this.altura + ".");
        return informacion;
    }



}
