package com.mercadolibre.fp_be_java_hisp_w15_g06.config;
import com.mercadolibre.fp_be_java_hisp_w15_g06.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure ( HttpSecurity http ) throws Exception {
        http.csrf()
                .disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(
                        "/api/v1/users/admin-1",
                        "/api/v1/users/admin-2"
                ).hasAnyAuthority("ADMIN")
                .antMatchers(
                        "/api/v1/users/buyer-1",
                        "/api/v1/users/buyer-2", "/api/v1/fresh-products/orders"
                ).hasAnyAuthority("BUYER")

                .antMatchers(HttpMethod.POST, "/api/v1/sign-in")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/ping")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/v3/api-docs")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/fake")
                .permitAll()

                .anyRequest()
                .permitAll();
    }

    /**
     * Configuración para excluir paginas
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure ( WebSecurity web ) throws Exception {
        web.ignoring()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**");

        web.ignoring()
                .antMatchers(
                        "/h2-console/**");
    }

}
