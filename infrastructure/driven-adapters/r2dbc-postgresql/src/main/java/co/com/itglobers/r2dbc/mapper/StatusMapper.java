package co.com.itglobers.r2dbc.mapper;

import co.com.itglobers.model.product.dto.Status;
import co.com.itglobers.r2dbc.entity.StatusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StatusMapper {

    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    Status toModel(StatusEntity statusEntity);

    StatusEntity toEntity(Status status);
}
