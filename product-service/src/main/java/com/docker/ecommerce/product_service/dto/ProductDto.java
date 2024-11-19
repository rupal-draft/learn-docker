package com.docker.ecommerce.product_service.dto;


public class ProductDto {
    private String title;
    private Double price;

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
