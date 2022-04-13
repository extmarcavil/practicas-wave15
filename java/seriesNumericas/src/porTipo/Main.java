package porTipo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SerieDeDouble de2 = new SerieDeDouble(3.0, 2.5);
        System.out.println(de2.siguienteSerieProgresiva());
        System.out.println(de2.siguienteSerieProgresiva());
        System.out.println(de2.siguienteSerieProgresiva());

        SerieDeInteger de3 = new SerieDeInteger(2,4);
        System.out.println(de3.siguienteSerieProgresiva());
        System.out.println(de3.siguienteSerieProgresiva());

        System.out.println(de3.siguienteSerieProgresiva());
        System.out.println(de3.siguienteSerieProgresiva());
        de3.setearInicioSerie(4);
        System.out.println(de3.siguienteSerieProgresiva());

    }
}
