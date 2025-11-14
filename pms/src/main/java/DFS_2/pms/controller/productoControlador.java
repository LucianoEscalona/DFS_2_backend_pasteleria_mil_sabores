package DFS_2.pms.controller;

import DFS_2.pms.entity.producto;
import DFS_2.pms.service.productoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class productoControlador {
    
    @Autowired
    private productoServicio servicio;
    
    @PostMapping("/addProducto")
    public producto c_guardarProducto(@RequestBody producto p){
        return servicio.guardadProducto(p);
    }
    @PostMapping("/addProductos")
    public List<producto> c_guardarProductos(@RequestBody List<producto> ls_p){
        return servicio.guardarProductos(ls_p);
    }
    
    @GetMapping("/productos")
    public List<producto> c_obtenerProductos(){
        return servicio.obtenerProductos();
    }
    @GetMapping("/productoByID/{p_id}")
    public producto c_obtenerProductoID(@PathVariable int p_id){
        return servicio.obtenerProductoID(p_id);
    }
    /*
    @GetMapping("/productoByCategoria/{p_categoria}")
    public producto c_obtenerProductoCategoria(@PathVariable String p_categoria){
        return servicio.obtenerProductoCategoria(p_categoria);
    }
    @GetMapping("/productoByNombre/{p_nombre}")
    public producto c_obtenerProductoNombre(@PathVariable String p_nombre){
        return servicio.obtenerProductoNombre(p_nombre);
    }
    */
    @PutMapping("/modificarProducto")
    public producto c_modificarProducto(@RequestBody producto p){
        return servicio.modificarProducto(p);
    }
    
    @DeleteMapping("/eliminarProducto/{p_id}")
    public String c_borrarProducto(@PathVariable int p_id){
        return servicio.borrarProducto(p_id);
    }
}
