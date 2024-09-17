package co.com.itglobers.api;

import co.com.itglobers.api.handler.ProductHandler;
import co.com.itglobers.model.product.dto.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterProductRest {
    @RouterOperations(
            {
                    @RouterOperation(path = "/api/v1/product/{id}"
                            , produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET, beanClass = ProductHandler.class, beanMethod = "getProduct",
                            operation = @Operation(operationId = "getProduct", responses = {
                                    @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ProductResponse.class))),
                                    @ApiResponse(responseCode = "400", description = "Invalid product")}, parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")})),
                    @RouterOperation(path = "/api/v1/product/save", produces = {
                            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = ProductHandler.class, beanMethod = "saveProduct",
                            operation = @Operation(operationId = "saveProduct", responses = {
                                    @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ProductResponse.class))),
                                    @ApiResponse(responseCode = "400", description = "Invalid Employee details supplied")}
                                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ProductResponse.class)))
                            )),
                    @RouterOperation(path = "/api/v1/product/update", produces = {
                            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.PUT, beanClass = ProductHandler.class, beanMethod = "updateProduct",
                            operation = @Operation(operationId = "updateProduct", responses = {
                                    @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ProductResponse.class))),
                                    @ApiResponse(responseCode = "400", description = "Invalid Employee details supplied")}
                                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ProductResponse.class)))
                            ))
            })


    @Bean
    public RouterFunction<ServerResponse> routerProductFunction(ProductHandler handler) {
        return nest(path("/api/v1/product"),
                route(GET("/{id}"), handler::getProduct)
                        .andRoute(POST("/save"), handler::saveProduct)
                        .andRoute(PUT("/update"), handler::updateProduct)
        );
    }
}
