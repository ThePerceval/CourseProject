package ru.vsu.csf.alcomanager.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.vsu.csf.alcomanager.model.Alcohol;
import ru.vsu.csf.alcomanager.model.Food;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
public class PartyDTO {

    private Long id;
    private String name;
    private String place;
    private LocalDateTime date;
    private List<Alcohol> alcohols;
    private List<Food> foods;
    private UserDTO users;

    @Override
    public String toString() {
        return "PartyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", date=" + date + '\'' +
                ", alcohols=" + alcohols + '\'' +
                ", foods=" + foods + '\'' +
                '}';
    }
}
