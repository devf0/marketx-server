package net.marketx.server.services;

import org.junit.jupiter.api.Test;

import net.marketx.server.entities.ProductEntity;
import net.marketx.server.models.Product;
import net.marketx.server.repositories.ProductRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;

import java.util.Optional;
import java.util.UUID;

public class ProductServiceImplTest {
    private Faker faker = new Faker();
    private Commerce commerce = faker.commerce();

    @Test
    public void testService() {
        ProductRepository repository = mock(ProductRepository.class);
        String mockId = UUID.randomUUID().toString();
        String mockName = commerce.productName();

        when(repository.findById(mockId)).thenReturn(Optional.of(new ProductEntity(mockId, mockName)));

        ProductServiceImpl service = new ProductServiceImpl(repository);
        Product result = service.findProduct(mockId);

        assertEquals(mockId, result.getId());
        assertEquals(mockName, result.getName());
    }
}

