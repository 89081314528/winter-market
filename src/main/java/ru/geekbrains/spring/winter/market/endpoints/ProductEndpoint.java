package ru.geekbrains.spring.winter.market.endpoints;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.spring.winter.market.services.ProductService;
import ru.geekbrains.spring.winter.market.soap.GetAllProductResponse;
import ru.geekbrains.spring.winter.market.soap.GetAllProductsRequest;
import ru.geekbrains.spring.winter.market.soap.GetProductsByIdRequest;
import ru.geekbrains.spring.winter.market.soap.GetProductsByIdResponse;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.flamexander.com/spring/ws/products";
    private final ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsByIdRequest")
    @ResponsePayload
    public GetProductsByIdResponse getProductsById(@RequestPayload GetProductsByIdRequest request) {
        GetProductsByIdResponse response = new GetProductsByIdResponse();
        response.setProduct(productService.getByIdSoap(request.getId()));
        return response;
    }

    /*
        Пример запроса: POST http://localhost:8080/ws
        Header -> Content-Type: text/xml

        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.flamexander.com/spring/ws/products">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getAllProductsRequest/>
            </soapenv:Body>
        </soapenv:Envelope>
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
        GetAllProductResponse response = new GetAllProductResponse();
        productService.getAllProductsSoap().forEach(response.getProducts()::add);
        return response;
    }
}
