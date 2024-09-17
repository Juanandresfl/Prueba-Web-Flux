package co.com.itglobers.model.product.gateways;

import co.com.itglobers.model.product.dto.ProductResponse;
import co.com.itglobers.model.product.dto.ProductRequest;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<ProductResponse> getProduct(Integer id);
    Mono<ProductResponse> saveProduct(ProductRequest product);
    Mono<ProductResponse> updateProduct(ProductRequest product);
}
