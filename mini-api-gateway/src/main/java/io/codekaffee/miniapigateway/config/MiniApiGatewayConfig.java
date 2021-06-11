package io.codekaffee.miniapigateway.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiniApiGatewayConfig {
    
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){

        Function<PredicateSpec, Buildable<Route>> function = 
            p -> p.path("/get")
                .filters(f -> 
                    f.addRequestHeader("Hello", "World")
                        .addRequestParameter("language", "pt-br")
                    
                )
                .uri("http://httpbin.org:80");


        return builder
            .routes()
            .route(function)
            .route(routeFunc("/cambio-service/**", "lb://cambio-service"))
            .route(routeFunc("/book-service/**", "lb://book-service"))
            .build();
    }



    public Function<PredicateSpec, Buildable<Route>> routeFunc(String path, String toUri){
        return p -> p.path(path).uri(toUri);
    }
}
