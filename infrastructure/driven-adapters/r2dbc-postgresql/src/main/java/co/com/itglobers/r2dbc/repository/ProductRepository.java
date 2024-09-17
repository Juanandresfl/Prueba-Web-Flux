package co.com.itglobers.r2dbc.repository;

import co.com.itglobers.r2dbc.entity.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, Integer> {
}
