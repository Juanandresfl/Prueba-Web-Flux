package co.com.itglobers.api.handler;

import co.com.itglobers.model.product.dto.Status;
import co.com.itglobers.usecase.StatusUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class StatusHandler {
private  final StatusUseCase useCase;

    public Mono<ServerResponse> getStatus(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(useCase.getStatus(), Status.class);
    }

}
