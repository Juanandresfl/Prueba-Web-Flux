package co.com.itglobers.r2dbc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Table(name = "product", schema = "public")
@Data
public class ProductEntity {
    @Id
    @Column("product_id")
    private Integer id;
    private String name;
    private Integer status;
    private Integer stock;
    private String description;
    private Double price;
}
