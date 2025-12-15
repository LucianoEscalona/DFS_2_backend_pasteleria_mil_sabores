package DFS_2.pms.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    @Value("${api.key}")
    private String apiKey;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();

        return path.equals("/api/v1/productos")
            || path.equals("/api/v1/productoByID/**")
            || path.equals("/api/v1/login")
            || path.equals("/api/v1/addUsuario")
            || path.equals("/api/v1/modificarProducto")
            || path.equals("/api/v1/usuarios")
            || path.equals("/api/v1/addDetalle_boleta")
            || path.equals("/api/v1/addBoleta")
            || path.startsWith("/auth")
            || path.startsWith("/swagger")
            || path.startsWith("/v3/api-docs");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String requestApiKey = request.getHeader("X-API-KEY");
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("API_KEY recibida: " + request.getHeader("X-API-KEY"));
        System.out.println("Authorization header: " + request.getHeader("Authorization"));

        if (requestApiKey == null || !requestApiKey.equals(apiKey)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
