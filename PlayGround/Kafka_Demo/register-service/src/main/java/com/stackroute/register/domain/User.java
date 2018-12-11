package com.stackroute.register.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    private String email;
    private String username;
    @Transient
    private String password;
    private String firstName;
    private String lastName;
    private long phone;
}
