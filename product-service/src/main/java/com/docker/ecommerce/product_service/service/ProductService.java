package com.docker.ecommerce.product_service.service;

import com.docker.ecommerce.product_service.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();

    ProductDto createProduct(ProductDto productDto);
}
