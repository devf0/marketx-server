package net.marketx.server.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String createdAt;
    private String updatedAt;
}
