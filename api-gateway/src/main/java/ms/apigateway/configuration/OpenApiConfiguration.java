package ms.apigateway.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "API Gateway Service",
        version = "v1",
        description = "List of Services APIs"
))
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(getInfo());
    }

    private static io.swagger.v3.oas.models.info.Info getInfo() {
        return new io.swagger.v3.oas.models.info.Info()
                .title("API Gateway Service")
                .version("v1")
                .license(getLicense());
    }

    private static License getLicense() {
        return new License()
                .name("Apache 2.0")
                .url("https://springdoc.org");
    }
}
