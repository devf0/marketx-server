package net.marketx.server.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private String id;
    private String orderId;
    private String productId;
    private int quantity;
    private int price;
    private String createdAt;
    private String updatedAt;
}
