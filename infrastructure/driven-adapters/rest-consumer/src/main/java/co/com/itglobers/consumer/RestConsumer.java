package co.com.itglobers.consumer;

import co.com.itglobers.model.product.gateways.DiscountGateway;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements DiscountGateway {
    private final WebClient client;

    @CircuitBreaker(name = "getDiscount" /*, fallbackMethod = "testGetOk"*/)
    @Override
    public Mono<Double> getDiscountProduct(Integer productId) {
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/discount")
                        .queryParam("productId", productId)
                        .build())
                .retrieve()
                .bodyToMono(ObjectResponse.class)
                .map(ObjectResponse::getDiscount)
                .onErrorMap(WebClientResponseException.class, e -> {
                    System.err.println("Error: " + e.getMessage());
                    return e;
                });
    }
}
