package co.com.itglobers.api.exceptions;

import co.com.itglobers.model.product.exception.EmptyDataException;
import co.com.itglobers.model.product.exception.ErrorDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Slf4j
@RestControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(EmptyDataException.class)
    public Mono<ResponseEntity<ErrorDetail>> setup(Exception e) {
        String message = e.getMessage();
        String name = e.getClass().getSimpleName();
        int status = HttpStatus.NOT_FOUND.value();
        return Mono.just(ResponseEntity.status(status).body(
                ErrorDetail.builder()
                .code(status)
                .message(message)
                .data(name)
                .dateTime(LocalDateTime.now())
                .build()));
    }

}