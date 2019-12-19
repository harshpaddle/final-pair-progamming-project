package com.company.studentsrepositoryservie.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "student_id", nullable = false)
    private int studentId;
    @Column(name = "name")
    private String name;
    @Column(name = "score")
    private Integer score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return getId() == course.getId() &&
                getStudentId() == course.getStudentId() &&
                Objects.equals(getName(), course.getName()) &&
                Objects.equals(getScore(), course.getScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStudentId(), getName(), getScore());
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
