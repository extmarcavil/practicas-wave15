package principal;

public class Main {

    public static void main(String[] args) {
	 Prototipo<Integer> serie= new SerieProgresiva();

     serie.setValorInicial(0);
     serie.setProgresion(2);

     System.out.println(serie.getValorSig());
     System.out.println(serie.getValorSig());
     System.out.println(serie.getValorSig());
     System.out.println(serie.getValorSig());


     serie.reiniciar();
     System.out.println(serie.getValorSig());


    }
}
