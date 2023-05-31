package net.marketx.server.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private String description;
    private String category;
    private int price;
    private int stock;
    private String imageUrl;
    private String createdAt;
    private String updatedAt;
}
