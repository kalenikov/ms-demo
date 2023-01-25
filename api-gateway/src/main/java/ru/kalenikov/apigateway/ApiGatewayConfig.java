package ru.kalenikov.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.http.HttpMethod;

//@Configuration
public class ApiGatewayConfig {
//    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(
                "test_route", route -> route.path("/test/**")
                        .and()
                        .method(HttpMethod.GET)
                        .filters(filter -> filter.stripPrefix(1))
                        .uri("lb://eu-client")
        ).build();
    }
}
