package DFS_2.pms.controller;

import DFS_2.pms.entity.usuario;
import DFS_2.pms.service.usuarioServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Usuarios", description = "API para gestión de usuarios del sistema")
public class usuarioController {
    
    @Autowired
    private usuarioServicio servicio;
    
    @Operation(summary = "Crear un nuevo usuario", description = "Registra un nuevo usuario en el sistema")
    @PostMapping("/addUsuario")
    public usuario c_guardarUsuario(@RequestBody usuario u){
        return servicio.guardarUsuario(u);
    }
    @PostMapping("/addUsuarios")
    public List<usuario> c_guardarUsuarios(@RequestBody List<usuario> ls_u){
        return servicio.guardarUsuarios(ls_u);
    }
    
    @GetMapping("/usuarios")
    public List<usuario> c_obtenerUsuarios(){
        return servicio.obtenerUsuario();
    }
    @GetMapping("/usuarioByID/{u_id}")
    public usuario c_obtenerUsuarioID(@PathVariable int u_id){
        return servicio.obtenerUsuarioID(u_id);
    }
    
    @PutMapping("/modificarUsuario")
    public usuario c_modificarUsuario(@RequestBody usuario u){
        return servicio.modificarUsuario(u);
    }
    
    @DeleteMapping("eliminarUsuario/{u_id}")
    public String c_borrarUsuario(@PathVariable int u_id){
        return servicio.borrarUsuario(u_id);
    }
}
