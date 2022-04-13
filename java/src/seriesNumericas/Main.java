package seriesNumericas;

public class Main {
    public static void main(String[] args) {

        System.out.println("-- Valor inicial 0 y salto de 2 --");
        Serie2 s = new Serie2(2);
        s.establecerInicio(0);
        for(int i = 0; i < 4; i++)
            System.out.println(s.valorSiguiente());

        System.out.println("\n -- Valor inicial 1 y salto de 2 --");
        s.establecerInicio(1);
        for(int i = 0; i < 4; i++)
            System.out.println(s.valorSiguiente());

        System.out.println("\n -- Valor inicial 0 y salto de 3 --");
        s = new Serie2(3);
        s.establecerInicio(0);
        for(int i = 0; i < 4; i++)
            System.out.println(s.valorSiguiente());

        System.out.println("\n -- Valor inicial 1 y salto de 3 --");
        s.establecerInicio(1);
        for(int i = 0; i < 4; i++)
            System.out.println(s.valorSiguiente());
    }
}
