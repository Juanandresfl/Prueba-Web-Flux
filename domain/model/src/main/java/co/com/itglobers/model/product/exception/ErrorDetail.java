package co.com.itglobers.model.product.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorDetail {

    private Integer code;
    private String data;
    private String message;
    private LocalDateTime dateTime;

}