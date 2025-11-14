package DFS_2.pms.controller;


import DFS_2.pms.entity.detalle_boleta;
import DFS_2.pms.service.detalle_boletaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class detalle_boletaControlador {
    
    @Autowired
    private detalle_boletaServicio servicio;
    
    @PostMapping("/addDetalle_boleta")
    public detalle_boleta c_guardarProducto(@RequestBody detalle_boleta db){
        return servicio.guardarDetalle_boleta(db);
    }@GetMapping("/detalle_boletas")
    public List<detalle_boleta> c_obtenerDetalle_boletas(){
        return servicio.obtenerDetalle_boletas();
    }
    @GetMapping("/etalle_boletaByID/{db_id}")
    public detalle_boleta c_obtenerDetalle_boletaID(@PathVariable int db_id){
        return servicio.obtenerDetalle_boletaID(db_id);
    }
    @DeleteMapping("/eliminarDetalle_boleta/{db_id}")
    public String c_borrarDetalle_boleta(@PathVariable int db_id){
        return servicio.borrarDetalle_boleta(db_id);
    }
}
