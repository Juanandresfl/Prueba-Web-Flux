package co.com.itglobers.model.product.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder(toBuilder = true)
public class ProductResponse {
    private Integer id;
    private String name;
    private Integer status;
    private Integer stock;
    private String description;
    private Double price;
    private Double discount;
    private Double finalPrice;

}
