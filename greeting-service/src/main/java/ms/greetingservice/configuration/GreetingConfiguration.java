package ms.greetingservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "greeting-service", ignoreInvalidFields = true)
public class GreetingConfiguration {
    private String greeting;
    private String defaultValue;
}
