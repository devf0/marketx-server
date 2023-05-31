package net.marketx.server.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testModel() {
        Product model = new Product();
        model.setName("Sweatshirt");
        model.setDescription("Sweatshirt");
        model.setCategory("tshirt");
        model.setPrice(12);
        model.setStock(1000);
        model.setImageUrl("https://example.com");

        assertEquals("Sweatshirt", model.getName());
        assertEquals("Sweatshirt", model.getDescription());
        assertEquals("tshirt", model.getCategory());
        assertEquals(12, model.getPrice());
        assertEquals(1000, model.getStock());
        assertEquals("https://example.com", model.getImageUrl());
    }
}
