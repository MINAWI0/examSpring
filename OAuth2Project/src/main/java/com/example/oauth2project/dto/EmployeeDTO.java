package com.example.oauth2project.dto;


import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String skill;


}