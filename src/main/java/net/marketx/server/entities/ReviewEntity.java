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
@Table(name = "reviews")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String userId;
    private String productId;
    private int rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    private String createdAt;
    private String updatedAt;
}
