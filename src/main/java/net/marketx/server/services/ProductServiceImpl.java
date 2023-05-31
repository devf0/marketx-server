package net.marketx.server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import net.marketx.server.entities.ProductEntity;
import net.marketx.server.models.Product;
import net.marketx.server.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private S3Service s3Service;

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<Product> products = new ArrayList<>();

        products = productEntities.stream()
            .map((productEntity) -> {
                Product product = new Product();
                BeanUtils.copyProperties(productEntity, product);
                return product;
            })
            .collect(Collectors.toList());
        return products;
    }

    @Override
    @Transactional
    public Product addProduct(Product product, MultipartFile image) {
        try {
            ProductEntity productEntity = new ProductEntity();
            BeanUtils.copyProperties(product, productEntity);
            productEntity = productRepository.save(productEntity);

            // if (productEntity != null) {
            //     product.setId(productEntity.getId());
            //     String imageUrl = uploadImage(product.getId(), image);
            //     productEntity.setImageUrl(imageUrl);
            //     productEntity = productRepository.save(productEntity);
            //     product.setImageUrl(imageUrl);
            //     return product;
            // } else {
            //     return null;
            // }

            if (productEntity != null) {
                product.setId(productEntity.getId());
                String imageUrl = s3Service.uploadFile(image);
                productEntity.setImageUrl(imageUrl);
                productEntity = productRepository.save(productEntity);
                product.setImageUrl(imageUrl);
                return product;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product findProduct(String id) {
        try {
            Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
            ProductEntity productEntity = productEntityOptional.orElse(null);
            Product product = new Product();
            BeanUtils.copyProperties(productEntity, product);
            return product;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    
    
}
