package com.bootcamp.joyeria.Controller;

import com.bootcamp.joyeria.Dto.Request.JoyaRequestDTO;
import com.bootcamp.joyeria.Dto.Response.JoyaResponseCreatedDTO;
import com.bootcamp.joyeria.Dto.Response.JoyaResponseDTO;
import com.bootcamp.joyeria.Service.Interfaces.JoyeriaInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyeriaController {

    private final JoyeriaInterface joyeriaService;

    public JoyeriaController(JoyeriaInterface joyeriaService) {
        this.joyeriaService = joyeriaService;
    }

    //    Crear una nueva joya y devolver el correspondiente status code con un mensaje informando su “nro identificatorio”. (URI: /jewerly/new).
    @PostMapping("/new")
    public ResponseEntity<JoyaResponseCreatedDTO> crearJoya(@RequestBody JoyaRequestDTO joyaRequestDTO) {
        Long identificador = joyeriaService.guardarJoya(joyaRequestDTO);
        return new ResponseEntity<JoyaResponseCreatedDTO>(new JoyaResponseCreatedDTO("Joya creada exitosamente, codigo creacion:" + identificador), org.springframework.http.HttpStatus.CREATED);
    }

    //    Devolver el listado de todas las joyas registradas. (URI: /jewerly).
    @GetMapping()
    public ResponseEntity<List<JoyaRequestDTO>> listarJoyas() {
        System.out.println(joyeriaService.listarJoyasVendidas());
        return new ResponseEntity<>(joyeriaService.listarJoyasVendidas(), HttpStatus.OK);
    }

    //
    @GetMapping("/todas")
    public List<JoyaResponseDTO> joyas() {
        return joyeriaService.listarJoyas();
    }

    //    Eliminar “lógicamente” una joya. Para ello, se deberá contemplar un campo que
//    se llama “ventaONo”, el cual debe ser verdadero al crear una nueva joya, y falso
//    cuando se solicite el eliminado.En caso de estar eliminado lógicamente, no deberá
//    ser devuelto en el listado de joyas registradas. (URI: /jewerly/delete/{id})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JoyaResponseCreatedDTO> eliminarJoya(@PathVariable("id") Long id) {
        joyeriaService.eliminarJoya(id);
        return new ResponseEntity<JoyaResponseCreatedDTO>(new JoyaResponseCreatedDTO("Joya eliminada exitosamente"), HttpStatus.CREATED);
    }

    //    Actualizar los datos de una joya. Una vez actualizados, devolver un mensaje con el
//    correspondiente status code y los datos de la joya modificada. (URI: /jewerly/update/{id_modificar}).
//    Envía el objeto completo para editar (sin cambiar la id).
    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaRequestDTO> updateJoya(@PathVariable("id") Long id, @RequestBody JoyaRequestDTO joyaRequestDTO) {
        joyeriaService.actualizarJoya(id, joyaRequestDTO);
        return new ResponseEntity<JoyaRequestDTO>(joyaRequestDTO, HttpStatus.CREATED);
    }


}
