package saveTheRopa.modelo;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa=new GuardaRopa();
        List<Prenda> prendaList=List.of(
                new Prenda("Kike","Lordan"),
                new Prenda("Adila","Oligen")
        );
        guardaRopa.guardarPrendas(prendaList);

        List<Prenda> list=List.of(
                new Prenda("Kike","Lordan")
        );
        guardaRopa.guardarPrendas(list);
        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.devolverPrendas(1));
        guardaRopa.devolverPrendas(3);


    }
}
