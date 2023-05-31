package net.marketx.server.repositories;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;

import net.marketx.server.entities.ProductEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.UUID;

public class ProductRepositoryTest {
    private Faker faker = new Faker();
    private Commerce commerce = faker.commerce();
    
    @Test
    public void testRepository() {
        ProductRepository repository = mock(ProductRepository.class);
        String mockId = UUID.randomUUID().toString();
        String mockName = commerce.productName();

        when(repository.findById(mockId)).thenReturn(Optional.of(new ProductEntity(mockId, mockName)));

        Optional<ProductEntity> resultOpt = repository.findById(mockId);
        ProductEntity result = resultOpt.orElse(null);

        assertEquals(mockId, result.getId());
        assertEquals(mockName, result.getName());
    }
}
