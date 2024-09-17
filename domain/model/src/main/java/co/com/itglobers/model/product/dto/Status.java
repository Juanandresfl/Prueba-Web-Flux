package co.com.itglobers.model.product.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Status {
    private Integer id;
    private String name;

}
