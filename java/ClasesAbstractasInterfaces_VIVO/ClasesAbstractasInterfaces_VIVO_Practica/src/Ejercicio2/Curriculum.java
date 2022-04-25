package Ejercicio2;

public class Curriculum extends Documento {

    String nombre;
    String habilidad1;
    String habilidad2;
    String habilidad3;
    String habilidad4;

    public Curriculum(String nombre, String habilidad1, String habilidad2, String habilidad3, String habilidad4) {
        this.nombre = nombre;
        this.habilidad2 = habilidad2;
        this.habilidad1 = habilidad1;
        this.habilidad3 = habilidad3;
        this.habilidad4 = habilidad4;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("---Curriculum---\n"+"Nombre: " + nombre +"\nHabilidad 1; " + habilidad2+"\nHabilidad 2; " + habilidad1+"\nHabilidad 3; " + habilidad3+"\nHabilidad 4; " + habilidad4);
    }
}
