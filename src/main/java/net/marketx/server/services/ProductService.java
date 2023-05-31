package net.marketx.server.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.marketx.server.models.Product;

public interface ProductService {

    List<Product> listProducts();

    Product addProduct(Product product, MultipartFile image);

    Product findProduct(String id);
    
}
