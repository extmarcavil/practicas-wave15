package com.mercadolibre.fp_be_java_hisp_w15_g06.security;

import com.mercadolibre.fp_be_java_hisp_w15_g06.util.Token;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";

    /**
     * Filtro para solicitar validación por token
     *
     * @param request  petition of client
     * @param response response for client
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain chain ) throws ServletException, IOException {
        try {
            if (!existeJWTToken(request)) {
                SecurityContextHolder.clearContext();
            } else {
                Claims claims = validateToken(request);
                if (claims.get("authorities") == null) {
                    SecurityContextHolder.clearContext();
                } else {
                    setUpSpringAuthentication(claims);
                }
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }

    /**
     * Método para validar el token
     *
     * @param request petition of client
     * @return if the token is valid, return the roles of user authenticated
     */
    private Claims validateToken ( HttpServletRequest request ) {
        String secret = Token.SECRET.getValue();

        String jwtToken = request.getHeader(HEADER)
                .replace(PREFIX, "");
        return Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(jwtToken)
                .getBody();
    }
    /**
     * Función para autenticarnos dentro del flujo de Spring
     *
     * @param claims roles of the user authenticated by token
     */
    private void setUpSpringAuthentication ( Claims claims ) {
        @SuppressWarnings("unchecked")
        List<String> authorities = (List) claims.get("authorities");

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                authorities.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
        SecurityContextHolder.getContext()
                .setAuthentication(auth);
    }

    /**
     * Verifica si existe la cabecera "Authorization" y cuyo valor comience con "Bearer"
     *
     * @param request petition of client
     * @return boolean indicate if the request contain a token
     */
    private boolean existeJWTToken ( HttpServletRequest request ) {
        String authenticationHeader = request.getHeader(HEADER);
        return authenticationHeader != null && authenticationHeader.startsWith(PREFIX);
    }
}
