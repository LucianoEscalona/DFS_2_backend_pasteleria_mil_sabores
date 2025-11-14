package DFS_2.pms.controller;

import DFS_2.pms.entity.boleta;
import DFS_2.pms.service.boletaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class boletaControlador {
    
    @Autowired
    private boletaServicio servicio;
    
    @PostMapping("/addBoleta")
    public boleta c_guardarBoleta(@RequestBody boleta b){
        return servicio.guardarBoleta(b);
    }
    @GetMapping("/boletas")
    public List<boleta> c_obtenerBoletas(){
        return servicio.obtenerBoletas();
    }
    @GetMapping("/boletasByID/{b_id}")
    public boleta c_obtenerBoletaID(@PathVariable int b_id){
        return servicio.obtenerBoletaID(b_id);
    }
    @DeleteMapping("/eliminarBoleta/{b_id}")
    public String c_borrarBoleta(@PathVariable int b_id){
        return servicio.borrarBoleta(b_id);
    }
}
