package co.com.itglobers.usecase;

import co.com.itglobers.model.product.dto.ProductResponse;
import co.com.itglobers.model.product.exception.EmptyDataException;
import co.com.itglobers.model.product.gateways.DiscountGateway;
import co.com.itglobers.model.product.gateways.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductUseCaseTest {

    @Mock
    private ProductService productService;

    @Mock
    private DiscountGateway discountGateway;

    @InjectMocks
    private ProductUseCase useCase;

    @BeforeEach
    void initialize() {
        useCase = new ProductUseCase(productService, discountGateway);
    }

    @Test
    void getProductTest() {
        ProductResponse product = ProductResponse.builder()
                .id(1)
                .description("prueba")
                .stock(100)
                .price(30.50)
                .name("prueba it globers")
                .status(0)
                .build();

        Mockito.doReturn(Mono.just(product)).when(productService).getProduct(anyInt());
        Mockito.doReturn(Mono.just(20.00)).when(discountGateway).getDiscountProduct(anyInt());

        StepVerifier.create(useCase.getProduct(1))
                .assertNext(productResponse -> {
                    assertThat(productResponse).isNotNull();
                    assertThat(productResponse).isExactlyInstanceOf(ProductResponse.class);
                    assertThat(productResponse.getDiscount()).isEqualTo(20.00);
                    assertThat(productResponse.getFinalPrice()).isNotNull();
                })
                .verifyComplete();

        verify(productService, times(1)).getProduct(anyInt());
        verify(discountGateway, times(1)).getDiscountProduct(anyInt());
    }

    @Test
    void errorGetProductTest() {
        Mockito.doReturn(Mono.empty()).when(productService).getProduct(anyInt());
        StepVerifier.create(useCase.getProduct(1))
                .expectError(EmptyDataException.class)
                .verify();
    }

}