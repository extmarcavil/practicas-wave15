package edad.calculaedad.controller;

import edad.calculaedad.dto.AgeDTO;
import edad.calculaedad.dto.BornDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/api")
public class CalculaedadController {

    /* Ejercicio hecho por mi. Podría haber usado directamente LocalDate en lugar de LocalDateTime */
    @GetMapping("/calcular/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable String dia,
                               @PathVariable String mes,
                               @PathVariable String anio) {

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

        //Duration d = Duration.between(start.toLocalTime(), end.toLocalTime());
        Period p = Period.between(start.toLocalDate(), end.toLocalDate());

        return String.valueOf(p.getYears());
    }

    /* Ejercicio hecho por el profe en la clase en vivo */
    @GetMapping("/calc/{day}/{month}")
    public String calcAgePath(@PathVariable Integer day,
                              @PathVariable Integer month,
                              @RequestParam(required = false) Integer year){

        LocalDate born = LocalDate.of(year,month,day);
        LocalDate now = LocalDate.now();
        Period period =  Period.between(born,now);

        return "Age: " + period.getYears();

    }

    @GetMapping("/dto/calc")
    //public AgeDTO calcAgePath(@RequestBody BornDTO born){
    public ResponseEntity<AgeDTO> calcAgePath(@RequestBody BornDTO born){

        LocalDate now = LocalDate.now();
        Period period =  Period.between(born.getBorn(),now);

        //return new AgeDTO(period.getYears());
        return new ResponseEntity<>(new AgeDTO(period.getYears()), HttpStatus.OK);
    }

}
