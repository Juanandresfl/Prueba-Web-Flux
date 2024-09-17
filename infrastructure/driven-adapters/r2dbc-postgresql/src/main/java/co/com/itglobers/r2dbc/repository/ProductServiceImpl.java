package co.com.itglobers.r2dbc.repository;

import co.com.itglobers.model.product.dto.ProductResponse;
import co.com.itglobers.model.product.dto.ProductRequest;
import co.com.itglobers.model.product.gateways.ProductService;
import co.com.itglobers.r2dbc.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper = ProductMapper.INSTANCE;


    @Override
    @Transactional
    public Mono<ProductResponse> getProduct(Integer id) {
        return productRepository
                .findById(id)
                .map(mapper::toModel);
    }

    @Override
    @Transactional
    public Mono<ProductResponse> saveProduct(ProductRequest product) {
        return productRepository
                .save(mapper.toEntity(product))
                .map(mapper::toModel);
    }

    @Override
    public Mono<ProductResponse> updateProduct(ProductRequest product) {
        return productRepository
                .save(mapper.toEntity(product))
                .map(mapper::toModel);
    }
}
