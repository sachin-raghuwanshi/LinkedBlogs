package com.programmers.blogwebsite.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private int id;
    @NotBlank @Size(min = 4, max = 32, message = "User name should be of at least 4 length and at max 32 length")
    private String name;
    @Email
    private String email;
    @NotBlank
    private String about;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message="The password policy is: " +
            "At least 8 chars, " +
            "Contains at least one digit, " +
            "Contains at least one lower alpha char and one upper alpha char, " +
            "Contains at least one char within a set of special chars (@#%$^&+=)," +
            "Does not contain space, tab, etc. ")
    private String password;
}
