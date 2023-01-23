package ru.vsu.csf.alcomanager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.userdetails.UserDetails;
import ru.vsu.csf.alcomanager.model.Role;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private Role role;

    public UserDTO() {
    }

    public UserDTO(Long id, String login, String pass, String name, String surname) {
        setUsername(login);
        setPassword(pass);
        setName(name);
        setSurname(surname);
    }
}
