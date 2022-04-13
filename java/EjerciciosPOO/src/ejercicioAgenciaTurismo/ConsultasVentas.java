package ejercicioAgenciaTurismo;

import java.util.OptionalDouble;

public class ConsultasVentas {
    public static void localizadoresVendidos(Repositorio repositorio) {
        System.out.println(repositorio.getLocalizadores().size());
    }

    public static void cantidadTotalReservas(Repositorio repositorio) {
        int cantReservas = repositorio.getLocalizadores().stream().mapToInt(localizador -> localizador.getReservas()).sum();
        System.out.println(cantReservas);
    }

    public static void totalVentas(Repositorio repositorio) {
        double totalVentas = repositorio.getLocalizadores().stream().mapToDouble(localizador -> localizador.getTotal()).sum();
        System.out.println(totalVentas);
    }

    public static void promedioVentas(Repositorio repositorio) {
        OptionalDouble promedioVentas = repositorio.getLocalizadores().stream().mapToDouble(localizador -> localizador.getTotal()).average();
        System.out.println(promedioVentas.getAsDouble());
    }
}
