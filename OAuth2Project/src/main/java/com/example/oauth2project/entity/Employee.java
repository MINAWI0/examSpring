package com.example.oauth2project.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String skill;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

    @OneToMany(mappedBy = "post")
    private List<Post> post;


}
