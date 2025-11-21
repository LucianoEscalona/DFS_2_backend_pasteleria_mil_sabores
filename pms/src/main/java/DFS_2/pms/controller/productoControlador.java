package DFS_2.pms.controller;

import DFS_2.pms.entity.Producto;
import DFS_2.pms.service.ProductoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoControlador {
    
    @Autowired
    private ProductoServicio servicio;
    
    @PostMapping("/addProducto")
    public Producto c_guardarProducto(@RequestBody Producto p){
        return servicio.guardadProducto(p);
    }
    @PostMapping("/addProductos")
    public List<Producto> c_guardarProductos(@RequestBody List<Producto> ls_p){
        return servicio.guardarProductos(ls_p);
    }
    
    @GetMapping("/productos")
    public List<Producto> c_obtenerProductos(){
        return servicio.obtenerProductos();
    }
    @GetMapping("/productoByID/{p_id}")
    public Producto c_obtenerProductoID(@PathVariable int p_id){
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
    public Producto c_modificarProducto(@RequestBody Producto p){
        return servicio.modificarProducto(p);
    }
    
    @DeleteMapping("/eliminarProducto/{p_id}")
    public String c_borrarProducto(@PathVariable int p_id){
        return servicio.borrarProducto(p_id);
    }
}
