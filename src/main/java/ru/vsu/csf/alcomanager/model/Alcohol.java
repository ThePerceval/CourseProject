package ru.vsu.csf.alcomanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "alcohol")
public class Alcohol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "strength", nullable = false)
    private int strength;

    public Alcohol() {
    }

    public Alcohol(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Alcohol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Alcohol alcohol = (Alcohol) o;
        return id != null && Objects.equals(id, alcohol.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}