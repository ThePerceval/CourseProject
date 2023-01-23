package ru.vsu.csf.alcomanager.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
public class PartyDTO {
    private Long id;
    private String name;
    private String place;
    private LocalDateTime date;

    public PartyDTO(Long id, String name, String password, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.place = password;
        this.date = dateTime;
    }

    @Override
    public String toString() {
        return "PartyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + place + '\'' +
                ", dateTime=" + date +
                '}';
    }
}
