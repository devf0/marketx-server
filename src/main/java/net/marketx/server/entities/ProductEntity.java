package net.marketx.server.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;
    private String category;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int price;
    private int stock;
    private String imageUrl;
    private String createdAt;
    private String updatedAt;

    public ProductEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
