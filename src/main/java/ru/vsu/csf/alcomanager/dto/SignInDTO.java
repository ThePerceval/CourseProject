package ru.vsu.csf.alcomanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInDTO {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "SignInDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}