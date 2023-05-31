package net.marketx.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.marketx.server.entities.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    
}
