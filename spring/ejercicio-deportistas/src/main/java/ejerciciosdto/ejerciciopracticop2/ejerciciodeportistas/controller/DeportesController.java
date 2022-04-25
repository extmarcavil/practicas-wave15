package ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.controller;

import ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.db.DB;
import ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.dto.DeporteDTO;
import ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.dto.DeportistaDTO;
import ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.model.Deporte;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportesController {

    @RequestMapping("/findSports")
    public List<Deporte> getDeportes(){
        return List.copyOf(DB.getDeportes().values());
    }

    @RequestMapping("/findSport/{name}")
    public DeporteDTO getDeporte(@PathVariable String name){
        return new DeporteDTO(DB.getDeportes().get(name).getNivel());
    }

    @RequestMapping("/findSportsPersons")
    public List<DeportistaDTO> getDeportistas(){
        List<DeportistaDTO> list=new ArrayList<>();
        DB.getDeportistas().forEach((s, personas) -> {
            personas.forEach(
                    persona ->  list.add(new DeportistaDTO(persona.getNombre()+" "+ persona.getApellido(), s))
            );
        });
        return list;
    }



}
