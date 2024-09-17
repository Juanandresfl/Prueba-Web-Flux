package co.com.itglobers.model.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Integer id;
    private String name;
    private Integer status;
    private Integer stock;
    private String description;
    private Double price;

}
