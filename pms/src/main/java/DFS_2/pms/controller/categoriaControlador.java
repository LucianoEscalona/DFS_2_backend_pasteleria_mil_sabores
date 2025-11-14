package DFS_2.pms.controller;

import DFS_2.pms.entity.categoria;
import DFS_2.pms.service.categoriaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class categoriaControlador {
    
    @Autowired
    private categoriaServicio servicio;
    
    @PostMapping("/addCategoria")
    public categoria c_guardarCategoria(@RequestBody categoria c){
        return servicio.guardarCategoria(c);
    }
    @GetMapping("/categorias")
    public List<categoria> c_obtenerCategorias(){
        return servicio.obtenerCategorias();
    }
    @GetMapping("/categoriaByID/{c_id}")
    public categoria c_obtenerCategoriaID(@PathVariable int c_id){
        return servicio.obtenerCategoriaID(c_id);
    }
    @PutMapping("/modificarCategoria")
    public categoria c_modificarCategoria(@RequestBody categoria c){
        return servicio.modificarCategoria(c);
    }
    @DeleteMapping("/eliminarCategoria/{c_id}")
    public String c_borrarCategoria(@PathVariable int c_id){
        return servicio.borrarCategoria(c_id);
    }
}
