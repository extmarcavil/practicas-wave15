package ejercicio2;

public class Main {
    public static void main(String[] args) {

        Curriculum curriculum = new Curriculum("Cosme","Fulanito","12345",
                "Inpector nuclear","Tiene diferntes profesiones como heladero, cantante entre otras");

        LibrosPdf librosPdf = new LibrosPdf(100,"Max Power",
                "Las aventuras de billy y mandi","Suspenso");
        Informe informe = new Informe("La verdad estoy un poco cansado y no se que escribir",
                50,"Homero Jay Simpson","Guandulo Smiders");

        curriculum.imprimir();
        librosPdf.imprimir();
        informe.imprimir();
    }
}
