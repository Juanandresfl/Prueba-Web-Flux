package co.com.itglobers.model.product.gateways;

import reactor.core.publisher.Mono;

public interface DiscountGateway {

    Mono<Double> getDiscountProduct(Integer productId);
}
