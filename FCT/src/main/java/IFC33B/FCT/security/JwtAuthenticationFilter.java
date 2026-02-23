package cat.xaviersastre.jwtserver.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    //private final JwtTokenUtil jwtTokenUtil;
    //private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        // extrae el token JWT del header
        final String authorizationHeader = request.getHeader("Authorization");

        // username y jwt se inicializan a null
        String username = null;
        String jwt = null;

        // comprueba si el header de autorización no es nulo y comienza con "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

            // extrae el token JWT eliminando el prefijo "Bearer "
            jwt = authorizationHeader.substring(7);

            try {
                // extraer username desde el token JWT
                username = jwtTokenUtil.extractUsername(jwt);
            } catch (Exception e) {
                logger.error("JWT Token extraction error: " + e.getMessage());
            }
        }

        // comprobar si se ha extraído un username y no hay una autenticación ya establecida en el contexto de seguridad
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            //cargar los detalles del usuario utilizando el username extraído del token JWT
        }

    }
}
