package co.com.itglobers.r2dbc.mapper;

import co.com.itglobers.model.product.dto.ProductResponse;
import co.com.itglobers.model.product.dto.ProductRequest;
import co.com.itglobers.r2dbc.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductResponse toModel(ProductEntity productEntity);

    ProductEntity toEntity(ProductRequest product);
}
