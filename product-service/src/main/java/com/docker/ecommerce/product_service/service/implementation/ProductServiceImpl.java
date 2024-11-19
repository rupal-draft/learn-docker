package com.docker.ecommerce.product_service.service.implementation;

import com.docker.ecommerce.product_service.dto.ProductDto;
import com.docker.ecommerce.product_service.entity.Product;
import com.docker.ecommerce.product_service.repository.ProductRepository;
import com.docker.ecommerce.product_service.service.ProductService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger log = Logger.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getProducts() {
        log.info("Fetching products!!");
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .toList();
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Optional<Product> product = productRepository.findByTitle(productDto.getTitle());
        if(product.isPresent()){
            log.error("A product is already present with that name!!");
            throw new RuntimeException("A product is already present with that name!!");
        }
        Product inputProduct = modelMapper.map(productDto,Product.class);
        Product savedProduct = productRepository.save(inputProduct);
        log.info("Product saved!!");
        return modelMapper.map(savedProduct,ProductDto.class);
    }
}
