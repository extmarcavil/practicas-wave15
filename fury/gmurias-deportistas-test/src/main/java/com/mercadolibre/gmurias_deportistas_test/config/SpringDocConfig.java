package com.mercadolibre.gmurias_deportistas_test.config;

import static com.mercadolibre.gmurias_deportistas_test.util.ScopeUtils.getScopeValue;
import static com.mercadolibre.gmurias_deportistas_test.util.ScopeUtils.isLocalScope;
import static java.lang.String.format;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Configuration class for documentation.
 */
@Configuration
public class SpringDocConfig {

  private static final String LOCAL_URL = "http://localhost:8080";

  private static final String FURY_URL = "https://%s_%s.furyapps.io";

  /**
   * @param appName Application name.
   * @param description Application description.
   * @param version Application version.
   * @return OpenAPI bean used to generate documentation.
   */
  @Bean
  public OpenAPI customOpenAPI(
      @Value("${app.title}") String appName,
      @Value("${app.description}") String description,
      @Value("${app.version}") String version) {
    Info info = new Info()
        .title(appName)
        .version(version)
        .description(description)
        .contact(
            new Contact()
                .name("gonzalo murias")
                .email("gonzalo.murias@mercadolibre.com"));

    String url = isLocalScope() ? LOCAL_URL : format(FURY_URL, getScopeValue(), appName);
    Server server = new Server()
        .url(url)
        .description(format("Scope %s", getScopeValue()));

    return new OpenAPI()
        .components(new Components())
        .info(info)
        .addServersItem(server);
  }

  @Bean
  public ModelResolver modelResolver(ObjectMapper objectMapper) {
    return new ModelResolver(objectMapper);
  }

}
