package co.com.itglobers.r2dbc.repository;

import co.com.itglobers.r2dbc.entity.StatusEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StatusRepository extends ReactiveCrudRepository<StatusEntity, Integer> {
}
