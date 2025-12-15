package DFS_2.pms.auth;

import DFS_2.pms.entity.usuario;
import DFS_2.pms.security.JwtUtil;
import DFS_2.pms.service.usuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private usuarioServicio usuarioServicio;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        System.out.println("Correo recibido: " + request.getCorreo());
        System.out.println("Password recibida: " + request.getPassword());

        usuario u = usuarioServicio.obtenerUsuarioCorreo(request.getCorreo());

        System.out.println("Usuario encontrado: " + u);

        if (u == null) {
            throw new RuntimeException("Usuario no existe");
        }

        if (!u.getU_contrasenia().equals(request.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtUtil.generarToken(u.getU_correo());

        return Map.of("token", token);
    }
}