package porValorSerie;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SerieDeA2 de2 = new SerieDeA2(3);
        System.out.println(de2.siguienteSerieProgresiva());
        System.out.println(de2.siguienteSerieProgresiva());
        System.out.println(de2.siguienteSerieProgresiva());

        SerieDeA3 de3 = new SerieDeA3(2);
        System.out.println(de3.siguienteSerieProgresiva());
        System.out.println(de3.siguienteSerieProgresiva());
        de3.valorInicialSerie();
        System.out.println(de3.siguienteSerieProgresiva());
        System.out.println(de3.siguienteSerieProgresiva());
        de3.setearInicioSerie(0);
        System.out.println(de3.siguienteSerieProgresiva());

    }
}
