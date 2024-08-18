package ms.apigateway.configuration;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(ApiGatewayConfiguration::getHelloWorldRoute)
                .route(ApiGatewayConfiguration::getCambioServiceRoute)
                .route(ApiGatewayConfiguration::getBookServiceRoute)
                .build();
    }

    private static Buildable<Route> getHelloWorldRoute(PredicateSpec p) {
        return p.path("/get")
                .filters(f -> f.addRequestHeader("Hello", "World"))
                .uri("http://httpbin.org/");
    }

    private static Buildable<Route> getCambioServiceRoute(PredicateSpec p) {
        return p.path("/cambio-service/**")
                .uri("lb://cambio-service/");
    }

    private static Buildable<Route> getBookServiceRoute(PredicateSpec p) {
        return p.path("/book-service/**")
                .uri("lb://book-service");
    }
}
