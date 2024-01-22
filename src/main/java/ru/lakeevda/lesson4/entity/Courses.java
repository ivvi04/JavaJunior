package ru.lakeevda.lesson4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses", schema = "public", catalog = "schooldb")
public class Courses {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "title", nullable = false, length = 225)
    private String title;
    @Basic
    @Column(name = "duration", nullable = true)
    private Integer duration;

    public Courses (String title, Integer duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courses that = (Courses) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, duration);
    }
}
