package Abstractas;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Integer> lista = new ArrayList<>();
        SerieDeDos serieDos = new SerieDeDos(lista);

        serieDos.establecerInicio(3);
        int siguiente1 = serieDos.valorSiguiente();
        int siguiente2 = serieDos.valorSiguiente();
        int siguiente3 = serieDos.valorSiguiente();

        lista = serieDos.getSerie();

        System.out.println(lista);
        serieDos.reiniciarSerie();
        lista.clear();
        SerieDeTres serieTres = new SerieDeTres(lista);

        serieTres.establecerInicio(6);
        int siguiente = serieTres.valorSiguiente();
        int siguiente4 = serieTres.valorSiguiente();
        int siguiente5 = serieTres.valorSiguiente();
        int siguiente6 = serieTres.valorSiguiente();

        lista = serieTres.getSerie();

        System.out.println(lista);

    }


}
