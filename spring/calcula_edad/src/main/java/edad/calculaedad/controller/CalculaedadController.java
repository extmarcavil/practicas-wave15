package edad.calculaedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


@RestController
public class CalculaedadController {

    @GetMapping("/api/calcular/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio) {

        Calendar fechaHoy = new GregorianCalendar();
        LocalDateTime start = null;
        try {
            int anioInt = Integer.valueOf(anio);
            int mesInt = Integer.valueOf(mes);
            int diaInt = Integer.valueOf(dia);

            start = LocalDateTime.of(anioInt, mesInt, diaInt, 0, 0, 0);
        } catch (DateTimeException e) {
            return "FECHA INGRESADA INVALIDA";
        } catch (NumberFormatException e){
            return "INGRESE SOLO NUMEROS ENTEROS";
        }

        LocalDateTime end = LocalDateTime.of(fechaHoy.get(Calendar.YEAR), fechaHoy.get(Calendar.MONTH), fechaHoy.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

        Duration d = Duration.between(start.toLocalTime(), end.toLocalTime());
        Period p = Period.between(start.toLocalDate(), end.toLocalDate());

        return String.valueOf(p.getYears());
    }

}
