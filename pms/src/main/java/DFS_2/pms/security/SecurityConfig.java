package DFS_2.pms.security;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final ApiKeyFilter apiKeyFilter;

    public SecurityConfig(JwtFilter jwtFilter, ApiKeyFilter apiKeyFilter) {
        this.jwtFilter = jwtFilter;
        this.apiKeyFilter = apiKeyFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                //públicos
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/api/v1/productos").permitAll()
                .requestMatchers("/api/v1/productoByID/**").permitAll()
                .requestMatchers("/api/v1/modificarProducto").permitAll()
                .requestMatchers("/api/v1/login").permitAll()
                .requestMatchers("/api/v1/addUsuario").permitAll()
                .requestMatchers("/api/v1/usuarios").permitAll()
                .requestMatchers("/api/v1/addDetalle_boleta").permitAll()
                .requestMatchers("/api/v1/addBoleta").permitAll()
                .requestMatchers("/swagger/**", "/v3/api-docs/**").permitAll()
                //protegidos
                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
            )
            //ORDEN IMPORTANTE
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(apiKeyFilter, JwtFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:5173"));
        config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}