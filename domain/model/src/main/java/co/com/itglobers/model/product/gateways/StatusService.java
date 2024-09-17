package co.com.itglobers.model.product.gateways;

import co.com.itglobers.model.product.dto.Status;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StatusService {
    Flux<Status> getStatus();
}
