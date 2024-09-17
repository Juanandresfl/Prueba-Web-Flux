package co.com.itglobers.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class RequestTimingFilter implements WebFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestTimingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        long startTime = System.currentTimeMillis();

        return chain.filter(exchange).doOnTerminate(() -> {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            String method = exchange.getRequest().getMethod().toString();
            String path = exchange.getRequest().getPath().toString();
            String message = String.format("Request %s %s took %d ms", method, path, duration);

            // Registrar el tiempo de respuesta en el archivo de log
            logger.info(message);
        });
    }
}
