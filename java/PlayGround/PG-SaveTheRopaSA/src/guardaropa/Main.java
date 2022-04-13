package guardaropa;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Crear en la clase Main un escenario en el cual alguien guarde dos prendas, reciba
        //el código y luego reclame sus prendas.
        Prenda unBuzo = new Prenda("Kevington","Buzo");
        Prenda unPantalon = new Prenda("Facol","Pantalon");
        Prenda unaBufanda = new Prenda("Bufandita","Bufanda");

        GuardaRopa elGuardaropaDeSaveTheRopaSA = new GuardaRopa();

        ArrayList<Prenda> listaDePrendasAGuardar = new ArrayList<>();
        listaDePrendasAGuardar.add(unBuzo);
        listaDePrendasAGuardar.add(unPantalon);
        int ID = elGuardaropaDeSaveTheRopaSA.guardarPrendas(listaDePrendasAGuardar);
        elGuardaropaDeSaveTheRopaSA.mostrarPrendas();
        //System.out.println(elGuardaropaDeSaveTheRopaSA.devolverPrendas(ID));


        listaDePrendasAGuardar.clear();
        listaDePrendasAGuardar.add(unaBufanda);
        ID = elGuardaropaDeSaveTheRopaSA.guardarPrendas(listaDePrendasAGuardar);
        elGuardaropaDeSaveTheRopaSA.mostrarPrendas();
        System.out.println(elGuardaropaDeSaveTheRopaSA.devolverPrendas(ID));

    }
}
