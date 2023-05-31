package net.marketx.server.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import net.marketx.server.models.Product;
import net.marketx.server.services.ProductService;

// @CrossOrigin(origins = {"https://xadmin-laihuutoan.vercel.app", "https://xclient.vercel.app"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(
        @RequestPart("image") MultipartFile image,
        @RequestPart("name") String name,
        @RequestPart("category") String category,
        @RequestPart("description") String description,
        @RequestPart("price") String price,
        @RequestPart("stock") String stock
    ) {

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDateTime = now.format(formatter);
        Product product = Product.builder()
            .name(name)
            .category(category)
            .description(description)
            .price(Integer.parseInt(price))
            .stock(Integer.parseInt(stock))
            .createdAt(currentDateTime)
            .updatedAt(currentDateTime)
            .build();
        product = productService.addProduct(product, image);
        return product;
    }

    @GetMapping
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable String id) {
        return productService.findProduct(id);
    }
}
