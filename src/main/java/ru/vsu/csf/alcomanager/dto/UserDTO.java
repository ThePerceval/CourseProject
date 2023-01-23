package ru.vsu.csf.alcomanager.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.vsu.csf.alcomanager.model.Alcohol;
import ru.vsu.csf.alcomanager.model.Food;
import ru.vsu.csf.alcomanager.model.Role;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Role role;
    private List<PartyDTO> parties;
    private List<Food> foods;
    private List<Alcohol> alcohols;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role +
                ", parties=" + parties +
                ", foods=" + foods +
                ", alcohols=" + alcohols +
                '}';
    }
}
