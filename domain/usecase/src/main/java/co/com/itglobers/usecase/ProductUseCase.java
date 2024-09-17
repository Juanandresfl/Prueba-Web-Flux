package co.com.itglobers.usecase;

import co.com.itglobers.model.product.dto.ProductResponse;
import co.com.itglobers.model.product.dto.ProductRequest;
import co.com.itglobers.model.product.exception.EmptyDataException;
import co.com.itglobers.model.product.exception.SavedDataException;
import co.com.itglobers.model.product.gateways.DiscountGateway;
import co.com.itglobers.model.product.gateways.ProductService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductUseCase {
    private final ProductService productGateway;
    private final DiscountGateway discountGateway;

    public Mono<ProductResponse> getProduct(Integer id) {
        return productGateway.getProduct(id)
                .flatMap(product -> discountGateway.getDiscountProduct(id)
                        .map(discount -> {
                            product.setDiscount(discount);
                            calculateFinalPrice(product, discount);
                            return product;
                        }))
                .switchIfEmpty(Mono.error(new EmptyDataException()));
    }

    public Mono<ProductResponse> saveProduct(ProductRequest product) {
        return productGateway.saveProduct(product)
                .onErrorMap(Exception.class, e -> new SavedDataException());
    }

    private static void calculateFinalPrice(ProductResponse productResponse, Double discount) {
        Double finalPrice = (productResponse.getPrice() * (100 - discount) / 100);
        productResponse.setFinalPrice(finalPrice);
    }

    public Mono<ProductResponse> updateProduct(ProductRequest product) {
        return productGateway.updateProduct(product)
                .onErrorMap(Exception.class, e -> new SavedDataException());
    }
}
