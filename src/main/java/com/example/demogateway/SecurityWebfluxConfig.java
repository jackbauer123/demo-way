package com.example.demogateway;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableWebFluxSecurity
@Configuration
public class SecurityWebfluxConfig {


    @Autowired
    private TokenRelayGatewayFilterFactory filterFactory;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        //@formatter:off
        return builder.routes()
                .route("daisyday-demon7", r -> r.path("/customer/**")
                        .filters(f -> f.filter(filterFactory.apply()))
                        .uri("lb://customer"))
                .build();
        //@formatter:on
    }




    /*@Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {

        // @formatter:off
        http
                .authorizeExchange((authorize) -> authorize
                        .anyExchange().authenticated()
                )
                .oauth2Login(withDefaults())
                ;
        // @formatter:on
        return http.build();
    }

    @Bean
    MapReactiveUserDetailsService userDetailsService() {
        // @formatter:off
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        // @formatter:on
        return new MapReactiveUserDetailsService(user);
    }*/
}
