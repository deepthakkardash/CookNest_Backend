package com.cooknest.cooknest.in.dto;


import com.cooknest.cooknest.in.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {


    @Size(max = 20, min = 4,message = "Username must be 4-20 characters")
    @NotBlank(message = "Username is required")

    @UniqueUsername
    private String username;

    @Email(message = "Invalid Email")
//    @UniquesEmail
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(max = 10, min = 6, message = "Password must be 6-10 characters")
    private String password;

}
