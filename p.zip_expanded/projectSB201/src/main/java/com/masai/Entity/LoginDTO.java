package com.masai.Entity;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@AllArgsConstructor
@Data
public class LoginDTO {

    int loginId;

    String MobileNumber;

    String oldPass;

    @Size(min = 5, max = 16, message = "Password length should be between 8 and 16")
    @NotNull
    @NotBlank
    String newPass;
}
