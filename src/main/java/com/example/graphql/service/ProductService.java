package com.example.graphql.service;

import com.example.graphql.entity.Product;
import com.example.graphql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    //  Stock Updated
    public Product updateStock(int id, int stock) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id " + id));
        product.setStock(stock);
        return productRepository.save(product);
    }

    //  New Shipment
    public Product receiveNewShipment(int id, int quantity) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id " + id));
        existingProduct.setStock(existingProduct.getStock() + quantity);
        return productRepository.save(existingProduct);
    }
}
