package co.com.itglobers.api.handler;

import co.com.itglobers.model.product.dto.ProductResponse;
import co.com.itglobers.model.product.dto.ProductRequest;
import co.com.itglobers.usecase.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductHandler {
private  final ProductUseCase useCase;

    public Mono<ServerResponse> getProduct(ServerRequest serverRequest) {
        Integer productId = Integer.valueOf(serverRequest.pathVariable("id"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(useCase.getProduct(productId), ProductResponse.class);
    }

    public Mono<ServerResponse> saveProduct(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ProductRequest.class)
                .flatMap(product -> ServerResponse.ok().body(useCase.saveProduct(product), ProductResponse.class));
    }

    public Mono<ServerResponse> updateProduct(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ProductRequest.class)
                .flatMap(product -> ServerResponse.ok().body(useCase.updateProduct(product), ProductResponse.class));
    }

}
