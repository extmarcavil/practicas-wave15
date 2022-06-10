package com.mercadolibre.fp_be_java_hisp_w15_g06.service.securitySession;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.requestDTO.UserRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.UserResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.AgentNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Rol;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.User;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IUserRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.util.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceSessionImp implements IServiceSession {

    private final IUserRepository userRepository;

    public ServiceSessionImp(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //ToDo: Ver Password con tim.
    @Override
    public UserResponseDTO login(UserRequestDTO userRequestDTO) {
        String username = userRequestDTO.getUsername();

        User user = userRepository.findByUsernameAndPassword(username, userRequestDTO.getPassword())
                .orElseThrow(AgentNotFoundException::new);

        String token = getJWTToken(username, user.getRol().getRol().getText());

        return new UserResponseDTO(username, token);
    }

    /**
     * Genera un token para un usuario específico, válido por 10'
     *
     * @param username - user to login
     * @param rol    - user's rol
     * @return String
     */
    /* lista de roles */
    private String getJWTToken ( String username, String rol ) {

        String secret = Token.SECRET.getValue();

        List<String> roles = new ArrayList<>();
        roles.add(rol);

        LocalDateTime expired = LocalDateTime.now()
                .plusMinutes(10);
        Date expiredTime = Date.from(expired.atZone(ZoneId.systemDefault())
                .toInstant());

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        roles
                )
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiredTime)
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
      
        return token;
    }

    /**
     * Decodifica un token para poder obtener los componentes que contiene el mismo
     *
     * @param token tokenJWT
     * @return Claims
     */
    private static Claims decodeJWT (String token ) {
        String secret = Token.SECRET.getValue();

        Claims claims = Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    /**
     * Permite obtener el username según el token indicado
     *
     * @param token token JWT
     * @return String User's Email
     */
    @Override
    public String getUsername ( String token ) {
        String[] parts = token.split(" ");
        String tokenParse = parts[1];

        Claims claims = decodeJWT(tokenParse);
        return claims.get("sub", String.class);
    }

}

