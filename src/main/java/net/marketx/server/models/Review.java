package net.marketx.server.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private String id;
    private String userId;
    private String productId;
    private int rating;
    private String comment;
    private String createdAt;
    private String updatedAt;
}
