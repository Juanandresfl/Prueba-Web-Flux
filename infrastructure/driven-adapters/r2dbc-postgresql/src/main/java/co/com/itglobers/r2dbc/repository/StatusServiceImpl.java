package co.com.itglobers.r2dbc.repository;

import co.com.itglobers.model.product.dto.Status;
import co.com.itglobers.model.product.gateways.StatusService;
import co.com.itglobers.r2dbc.mapper.StatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Repository
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper = StatusMapper.INSTANCE;

    @Value("${adapter.cache.time}")
    private Integer expirationTime;

    @Override
    public Flux<Status> getStatus() {
        return statusRepository.findAll()
                .cache(Duration.ofMinutes(expirationTime))
                .map(statusMapper::toModel);
    }
}
