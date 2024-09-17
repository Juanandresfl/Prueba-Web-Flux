package co.com.itglobers.usecase;

import co.com.itglobers.model.product.dto.Status;
import co.com.itglobers.model.product.exception.EmptyDataException;
import co.com.itglobers.model.product.gateways.StatusService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class StatusUseCase {
    private final StatusService serviceGateway;

    public Flux<Status> getStatus() {
        return serviceGateway.getStatus()
                .switchIfEmpty(Mono.error(new EmptyDataException()));
    }
}
