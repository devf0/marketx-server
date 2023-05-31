package net.marketx.server.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String userId;
    private int totalAmount;
    private int status;
    private String createdAt;
    private String updatedAt;
}
