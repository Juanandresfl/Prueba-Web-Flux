package co.com.itglobers.api;

import co.com.itglobers.api.handler.StatusHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterStatustRest {
    @Bean
    public RouterFunction<ServerResponse> routerStatusFunction(StatusHandler handler) {
        return nest(path("/api/v1/status"),
                route(GET(""), handler::getStatus)
        );
    }
}
