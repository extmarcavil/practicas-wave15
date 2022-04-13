package ejercicio2;

public class Main {

    public static void main(String[] args) {

        Curriculum unCV = new Curriculum();
        LibroPDF unPDF= new LibroPDF(500,"J. K. Rowling","Harry Potter y la Piedra Filosofal","Fantastico");
        Informe unInforme= new Informe();

        unCV.imprimir();
        System.out.println("");
        unPDF.imprimir();
        System.out.println("");
        unInforme.imprimir();
        System.out.println("");


    }
}
